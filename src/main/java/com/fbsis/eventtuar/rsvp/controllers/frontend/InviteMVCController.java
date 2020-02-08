package com.fbsis.eventtuar.rsvp.controllers.frontend;

import com.fbsis.eventtuar.rsvp.domain.invites;
import com.fbsis.eventtuar.rsvp.domain.party;
import com.fbsis.eventtuar.rsvp.repository.invitesRepository;
import com.fbsis.eventtuar.rsvp.repository.partyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("")
public class InviteMVCController {

    @Autowired
    public invitesRepository inviteRep;

    @Autowired
    public partyRepository partyRep;

    private static String UPLOADED_FOLDER = "D://dados//Coding//rsvp//imagens//";


    @GetMapping("/{inviteUrl}")
    public ModelAndView index(@PathVariable() String inviteUrl) {

        Optional<party> search = partyRep.findByInviteUrl(inviteUrl);

        if(!search.isPresent() || inviteUrl.equals("admin"))
            return new ModelAndView("Invite/invalido");

        ModelAndView modelAndView = new ModelAndView("Invite/index");
        modelAndView.addObject("url", inviteUrl);

        modelAndView.addObject("urlSave", "/"+inviteUrl+"/save");
        modelAndView.addObject("imagem", search.get().imagem);


        modelAndView.addObject("detalhes", search.get());

        return modelAndView;
    }


    @PostMapping("{inviteUrl}/save")
    public ModelAndView salvar(@PathVariable() String inviteUrl,
                               @RequestParam("nome") String name,
                               @RequestParam("sobrenome") String sobrenome,
                               @RequestParam(value = "acompanhante[]", required = false) String[] acompanhante,
                               @RequestParam(value = "idade[]", required = false) String[] idade) {

        party party = partyRep.findByInviteUrl(inviteUrl).get();

        Integer qtd = 0;
        if(acompanhante != null){
            qtd = acompanhante.length;
        }

        invites invite = new invites();
        invite.name = name;
        invite.data = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss").format( new Date()   );
        invite.sobrenome = sobrenome;

        for (int i = 0; i < qtd; i++) {
            invites companions = new invites();
            companions.name = acompanhante[i];
            companions.idade = idade[i];
            invite.companion.add(companions);
        }

        party.invites.add(invite);

        partyRep.save(party);

        ModelAndView modelAndView = new ModelAndView("redirect:/"+inviteUrl+"/sucesso");

        return modelAndView;
    }


    @GetMapping("{inviteUrl}/sucesso")
    public ModelAndView sucesso(@PathVariable() String inviteUrl) {
        Optional<party> search = partyRep.findByInviteUrl(inviteUrl);

        ModelAndView modelAndView = new ModelAndView("Invite/sucesso");

        modelAndView.addObject("url", inviteUrl);
        modelAndView.addObject("detalhes", search.get());

        return modelAndView;
    }

    @GetMapping(
            value = "{inviteUrl}/imagem",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @ResponseBody
    public FileSystemResource download(@PathVariable("inviteUrl")
                                   String inviteUrl, HttpServletResponse response) {
        response.setContentType("image/jpg");
        response.setHeader("Content-Disposition", " filename=imagem.jpg");
        return new FileSystemResource(new File(UPLOADED_FOLDER + inviteUrl));
    }

}
