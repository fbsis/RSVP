package com.fbsis.eventtuar.rsvp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class invites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String publicId;

    public String name;

    public String sobrenome;
    public String data;

    public String idade;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<invites> companion = new ArrayList<>();

    public int countCompanion(){
        return this.companion.size();
    }
}
