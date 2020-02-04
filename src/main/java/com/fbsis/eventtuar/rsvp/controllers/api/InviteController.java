package com.fbsis.eventtuar.rsvp.controllers.api;

import com.fbsis.eventtuar.rsvp.Exception.DoesNotExistsException;
import com.fbsis.eventtuar.rsvp.domain.invites;
import com.fbsis.eventtuar.rsvp.domain.party;
import com.fbsis.eventtuar.rsvp.repository.invitesRepository;
import com.fbsis.eventtuar.rsvp.repository.partyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/invite")
public class InviteController {

    @Autowired
    public invitesRepository inviteRep;

    @Autowired
    public partyRepository partyRep;

    @GetMapping("/")
    public Iterable<invites> getAllInvites() {
        Iterable<invites> search = inviteRep.findAll();
        return search;
    }

    @GetMapping("/{url}")
    public Iterable<invites> getAllInvitesByUrl(@PathVariable String url) {
        Optional<party> search = partyRep.findByInviteUrl(url);

        if(!search.isPresent() || search.get().invites.size() == 0){
            throw new DoesNotExistsException();
        }
        return search.get().invites;
    }

    @PostMapping("/{url}")
    public Iterable<invites> setInviterByUrl(@PathVariable String url, @RequestBody List<invites> invites) {
        Optional<party> search = partyRep.findByInviteUrl(url);

        if(!search.isPresent()) throw new DoesNotExistsException();

        party party = search.get();
        for (invites invite : invites) party.invites.add(invite);
        partyRep.save(party);

        return invites;
    }


    @PutMapping("/{url}")
    public invites editInviterByUrl(@PathVariable String url, @RequestBody invites invites) {
        Optional<party> search = partyRep.findByInviteUrl(url);

        if(!search.isPresent()) throw new DoesNotExistsException();

        Optional<invites> searchInvite = inviteRep.findInviteUsingPartyId(search.get().id, invites.id);

        if(!searchInvite.isPresent()) throw new DoesNotExistsException("Esse participante não está inscrito nessa festa ou não existe");

        inviteRep.save(invites);

        return invites;
    }

    @DeleteMapping("/{url}")
    public Iterable<invites> deleteInviterByUrl(@PathVariable String url, @RequestBody List<invites> invites) {
        Optional<party> search = partyRep.findByInviteUrl(url);

        if(!search.isPresent()) throw new DoesNotExistsException();

        party party = search.get();
        for (invites invite : invites) party.invites.remove(invite);
        partyRep.save(party);

        return invites;
    }

    @PostMapping("/{url}/{idInvite}/")
    public List<invites> addCompanion(@PathVariable String url, @PathVariable Integer idInvite, @RequestBody List<invites> invites) {
        Optional<party> search = partyRep.findByInviteUrl(url);

        if(!search.isPresent()) throw new DoesNotExistsException();

        Optional<invites> searchInvite = inviteRep.findInviteUsingPartyId(search.get().id, idInvite);

        if(!searchInvite.isPresent()) throw new DoesNotExistsException("Esse participante não está inscrito nessa festa ou não existe");

        invites invites2 = searchInvite.get();
        for (invites inviteJ : invites) invites2.companion.add(inviteJ);

        inviteRep.save(invites2);

        return invites;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public invites setParty(@RequestBody invites p) {
        inviteRep.save(p);
        return p;
    }

    @DeleteMapping(path = "/")
    public void deleteParty(@RequestBody invites p) {
        inviteRep.delete(p);
    }
}
