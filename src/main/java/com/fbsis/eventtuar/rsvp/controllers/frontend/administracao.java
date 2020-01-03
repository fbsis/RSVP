package com.fbsis.eventtuar.rsvp.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/AdminController/")
public class administracao {

    @GetMapping("/")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("AdminController/index");

        return modelAndView;
    }

}
