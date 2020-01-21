package com.fbsis.eventtuar.rsvp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String inviteUrl;

    public String eventName; // Casamento de Vanessa & Felipe

    public Date data;

    public Time hour;

    public String local;

    public String description;

    public String password;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<invites> invites = new ArrayList<>();

    public party() {
        this.inviteUrl = UUID.randomUUID().toString().substring(0,8);
    }

}
