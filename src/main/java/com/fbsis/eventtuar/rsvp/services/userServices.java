package com.fbsis.eventtuar.rsvp.services;

import com.fbsis.eventtuar.rsvp.controllers.request.adminCreateLoginRequest;
import com.fbsis.eventtuar.rsvp.controllers.request.adminLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.fbsis.eventtuar.rsvp.domain.user;
import com.fbsis.eventtuar.rsvp.repository.userRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class userServices {

    @Autowired
    public userRepository userRepository;

    public Iterable<user> getUsers(){
        return userRepository.findAll();
    }

    public user saveUser(String name, String email, String password, String namePage, Integer theme){

        //user User = new user(name, email, password, namePage, theme);
        user User = new user();

        User.name = name;
        User.email = email;
        User.password = password;
        User.namePage = namePage;
        User.theme = theme;

        return userRepository.save(User);
    }


    public user login(adminLoginRequest adminLoginRequest){

        Optional<user> search = userRepository.findBypassword(adminLoginRequest.password);

        Assert.isTrue(!search.isPresent(), "usuario não encontrado");

        return search.get();
    }
}
