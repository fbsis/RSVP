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

    public String phone;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<invites> companion = new ArrayList<>();

}
