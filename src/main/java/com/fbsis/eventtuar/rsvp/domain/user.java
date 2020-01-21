package com.fbsis.eventtuar.rsvp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class user {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer Id;

    public String name;

    public String email;

    public String password;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<party> parties = new ArrayList<>();

    public user(){

    }

    public user(String name, String email, String password, String namePage, Integer theme){
        this.name = name;
        this.email = email;
        this.password = password;

    }

}
