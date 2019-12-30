package com.fbsis.eventtuar.rsvp.controllers.api;

import com.fbsis.eventtuar.rsvp.domain.party;
import com.fbsis.eventtuar.rsvp.repository.partyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/party")
public class PartyController {

    @Autowired
    public partyRepository partyRep;

    @GetMapping("/")
    public Iterable<party> getAllParty() {
        Iterable<party> search = partyRep.findAll();
        return search;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public party setParty(@RequestBody party p) {
        partyRep.save(p);
        return p;
    }

    @DeleteMapping(path = "/")
    public void deleteParty(@RequestBody party p) {
        partyRep.delete(p);
    }
}
