package com.fbsis.eventtuar.rsvp.controllers.frontend;

import com.fbsis.eventtuar.rsvp.Exception.DoesNotExistsException;
import com.fbsis.eventtuar.rsvp.domain.party;
import com.fbsis.eventtuar.rsvp.repository.invitesRepository;
import com.fbsis.eventtuar.rsvp.repository.partyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("")
public class InviteMVCController {

    @Autowired
    public invitesRepository inviteRep;

    @Autowired
    public partyRepository partyRep;

    @GetMapping("/{inviteUrl}")
    public ModelAndView index(@PathVariable() String inviteUrl) {

        Optional<party> search = partyRep.findByInviteUrl(inviteUrl);

        if(!search.isPresent() || inviteUrl.equals("admin"))
            return new ModelAndView("Invite/invalido");

        ModelAndView modelAndView = new ModelAndView("Invite/index");
        modelAndView.addObject("url", inviteUrl);

        modelAndView.addObject("detalhes", search.get());

        return modelAndView;
    }

}
