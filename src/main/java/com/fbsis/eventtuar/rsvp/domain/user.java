package com.fbsis.eventtuar.rsvp.domain;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class user {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer Id;

    public String name;

    public String email;

    public String password;

    public String namePage;

    public Integer theme;

    public user(){

    }

    public user(String name, String email, String password, String namePage, Integer theme){
        this.name = name;
        this.email = email;
        this.password = password;
        this.namePage = namePage;
        this.theme = theme;

    }

}
