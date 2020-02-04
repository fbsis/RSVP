package com.fbsis.eventtuar.rsvp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Recurso não existe ou é inválido")
public class DoesNotExistsException extends RuntimeException{

    public DoesNotExistsException(){

    }

    public DoesNotExistsException(String mensagem){
        super(mensagem);
    }
}
