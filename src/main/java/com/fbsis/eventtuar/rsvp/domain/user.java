package com.fbsis.eventtuar.rsvp.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class user {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer Id;

    public String name;

    public String email;

    public String password;

    public user(){

    }

    public user(String name, String email, String password, String namePage, Integer theme){
        this.name = name;
        this.email = email;
        this.password = password;

    }

}
