package com.fbsis.eventtuar.rsvp.controllers.frontend;

import com.fbsis.eventtuar.rsvp.controllers.request.adminLoginRequest;
import com.fbsis.eventtuar.rsvp.domain.party;
import com.fbsis.eventtuar.rsvp.domain.user;
import com.fbsis.eventtuar.rsvp.repository.partyRepository;
import com.fbsis.eventtuar.rsvp.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin/")
public class AdminMVCController {

    @Autowired
    public userRepository userrepository;

    @Autowired
    public partyRepository partyRepository;

    private Boolean isLogged(HttpSession session){
        return session.getAttribute("logado") != null;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("admin/index");

        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView indexLogin(@RequestParam ("senha") String password, HttpSession session) {
        //vericando login
        Optional<user> search = userrepository.findBypassword(password);

        if(search.isPresent()){
            // gravando na sessao
            session.setAttribute("logado", search.get());

            return new ModelAndView("redirect:/admin/parties");
        }else{
            return new ModelAndView("redirect:/admin/?wrong-password");
        }
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("logado");
        return new ModelAndView("redirect:/admin/");
    }

    @GetMapping("/parties")
    public ModelAndView parties(HttpSession session) {
        if(!isLogged(session)){
            return new ModelAndView("redirect:/admin/?wrong-password");
        }

        ModelAndView modelAndView = new ModelAndView("admin/parties");

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(HttpSession session) {
        if(!isLogged(session)){
            return new ModelAndView("redirect:/admin/?wrong-password");
        }
        ModelAndView modelAndView = new ModelAndView("admin/parties_form");
        return modelAndView;
    }


    @PostMapping("/save")
    public ModelAndView saveParty(
            @RequestParam("eventName") String eventName,
            @RequestParam("data") String data,
            @RequestParam("hour") String hour,
            @RequestParam("local") String local,

            HttpSession session) {
        if(!isLogged(session)){
            return new ModelAndView("redirect:/admin/?wrong-password");
        }

/*        party partyResource = new party();
        partyResource = partyForm;

        partyRepository.save(partyResource);*/

        return new ModelAndView("redirect:/admin/parties/?msg=Salvo com sucesso");
    }


}
