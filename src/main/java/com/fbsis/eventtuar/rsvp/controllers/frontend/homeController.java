package com.fbsis.eventtuar.rsvp.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class homeController {

    @RequestMapping(value = "/")
    public void index(HttpServletResponse response) throws IOException {

        //return "index";
        response.sendRedirect("http://www.eventtuar.com.br/");
        
    }
}
