package com.fbsis.eventtuar.rsvp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String inviteUrl;

    public String namePage;

    public String description;

    public Integer theme;

    public String password;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<invites> invites = new ArrayList<>();

    party() {
        this.inviteUrl = UUID.randomUUID().toString();
    }

}
