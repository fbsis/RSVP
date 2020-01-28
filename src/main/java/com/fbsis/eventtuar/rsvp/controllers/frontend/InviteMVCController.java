package com.fbsis.eventtuar.rsvp.controllers.frontend;

import com.fbsis.eventtuar.rsvp.controllers.request.InviteRequest;
import com.fbsis.eventtuar.rsvp.domain.party;
import com.fbsis.eventtuar.rsvp.repository.invitesRepository;
import com.fbsis.eventtuar.rsvp.repository.partyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
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

        modelAndView.addObject("urlSave", "/"+inviteUrl+"/save");


        modelAndView.addObject("detalhes", search.get());

        return modelAndView;
    }


    @PostMapping("{inviteUrl}/save")
    public ModelAndView salvar(@RequestParam("nome") String nome,
                               @RequestParam("sobrenome") String sobrenome, @RequestParam("acompanhante[]") String[] acompanhante) {


        ModelAndView modelAndView = new ModelAndView("Invite/index");


        return modelAndView;
    }

}
