package com.fbsis.eventtuar.rsvp.controllers.frontend;

import com.fbsis.eventtuar.rsvp.domain.party;
import com.fbsis.eventtuar.rsvp.domain.user;
import com.fbsis.eventtuar.rsvp.repository.partyRepository;
import com.fbsis.eventtuar.rsvp.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminMVCController {

    @Autowired
    public userRepository userrepository;

    @Autowired
    public partyRepository partyRepository;

    private static String UPLOADED_FOLDER = "D://dados//Coding//rsvp//imagens//";


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
    public ModelAndView parties(HttpSession session, Model model) {
        if(!isLogged(session)){
            return new ModelAndView("redirect:/admin/?wrong-password");
        }

        ModelAndView modelAndView = new ModelAndView("admin/parties");

        modelAndView.addObject("parties", partyRepository.findAll());
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


    @GetMapping("/apagar/{id}")
    public ModelAndView apagar(HttpSession session, @PathVariable() Integer id) throws IOException {
        if(!isLogged(session)){
            return new ModelAndView("redirect:/admin/?wrong-password");
        }
        party resParty = partyRepository.findById(id).get();
        String local = UPLOADED_FOLDER + "/" + resParty.inviteUrl;

        if(Files.exists(Paths.get(local))){
            Files.delete(Paths.get(local));
        }
        partyRepository.deleteById(id);

        return new ModelAndView("redirect:/admin/parties?msg=Evento apagada com sucesso");
    }

    @PostMapping("/save")
    public ModelAndView saveParty(
            @RequestParam("eventName") String eventName,
            @RequestParam("data")  String data,
            @RequestParam("hour") String hour,
            @RequestParam("local")  String local,
            @RequestParam("description") String description,
            @RequestParam("imagem") MultipartFile file,

            HttpSession session) throws ParseException, IOException {
        if(!isLogged(session)){
            return new ModelAndView("redirect:/admin/?wrong-password");
        }

        party partyResource = new party();
        partyResource.eventName = eventName;
        partyResource.data = data;
        partyResource.hour = hour;
        partyResource.local = local;
        partyResource.description = description;


        // pegando o arquivo e salvando em algum lugar
        if(file.getBytes().length > 0){
            byte[] bytes = file.getBytes();
            Path path = Paths.get( UPLOADED_FOLDER +  partyResource.inviteUrl);
            Files.write(path, bytes);
            partyResource.imagem = "-";
        }
        partyRepository.save(partyResource);


        return new ModelAndView("redirect:/admin/parties/?msg=Salvo com sucesso");
    }

    @GetMapping("/invited/{id}")
    public ModelAndView convidados(HttpSession session, @PathVariable() Integer id) {
        if(!isLogged(session)){
            return new ModelAndView("redirect:/admin/?wrong-password");
        }

        party party = partyRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("admin/invited");

        modelAndView.addObject("party", party);

        return modelAndView;
    }



}
