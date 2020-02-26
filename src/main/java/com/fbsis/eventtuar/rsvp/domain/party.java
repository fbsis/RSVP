package com.fbsis.eventtuar.rsvp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public String data;

    public String hour;

    @Lob
    public String local;

    @Lob
    public String description;

    @Lob
    public String sucesso;

    public String password;

    public String imagem;

    public String imgVerso;

    public Boolean active;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<invites> invites = new ArrayList<>();

    public party() {
        this.inviteUrl = UUID.randomUUID().toString().substring(0,8);
        this.active = true;
    }

    public int countInvites(){
        return this.invites.size();
    }



}
