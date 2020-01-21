package com.fbsis.eventtuar.rsvp.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
