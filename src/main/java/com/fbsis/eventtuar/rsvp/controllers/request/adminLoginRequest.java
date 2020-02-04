package com.fbsis.eventtuar.rsvp.controllers.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class adminLoginRequest {

    @NotEmpty(message = "E necessário informar uma senha")
    @NotNull(message = "Não pode ser um valor vazio")
    public String password;
}