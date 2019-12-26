package com.fbsis.eventtuar.rsvp.controllers.request;

import com.fbsis.eventtuar.rsvp.domain.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class adminCreateLoginRequest {

    @NotEmpty(message = "O nome do usuário e obrigatório")
    public String name;

    @Email(message = "E necessário um e-mail válido")
    public String email;

    @NotEmpty(message = "Por favor informe uma senha")
    public String password;

    @NotEmpty(message = "Por favor informe uma nome que será usado como nome da página")
    public String namePage;

    public Integer theme;
}
