package com.fbsis.eventtuar.rsvp.controllers.api;

import com.fbsis.eventtuar.rsvp.controllers.request.adminCreateLoginRequest;
import com.fbsis.eventtuar.rsvp.controllers.request.adminLoginRequest;
import com.fbsis.eventtuar.rsvp.domain.user;
import com.fbsis.eventtuar.rsvp.services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/admin")
public class admin {

    @Autowired
    public userServices userservices;

    @GetMapping("/users")
    public Iterable<user> getUsers(){
        Iterable<user> search = userservices.getUsers();
        return search;
    }

    @PostMapping("/user")
    public adminCreateLoginRequest setUser(@RequestBody @Valid adminCreateLoginRequest User){

        userservices.saveUser(User.name, User.email, User.password, User.namePage, User.theme);
        return User;
    }

    @PostMapping("/login")
    public user login(@RequestBody @Valid adminLoginRequest adminlogin){
        return userservices.login(adminlogin);
    }
}
