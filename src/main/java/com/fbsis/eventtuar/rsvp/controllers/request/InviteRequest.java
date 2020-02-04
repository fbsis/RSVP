package com.fbsis.eventtuar.rsvp.controllers.request;


import com.fbsis.eventtuar.rsvp.domain.invites;

import java.util.ArrayList;
import java.util.List;

public class InviteRequest {
    public String name;
    public String sobrenome;
    public List<InviteRequest> acompanhantes = new ArrayList<>();
}
