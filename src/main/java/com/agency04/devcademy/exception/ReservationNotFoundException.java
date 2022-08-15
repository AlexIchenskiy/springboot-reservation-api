package com.agency04.devcademy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(Long id) {
        super("Could not find reservation of id " + id);
    }

}
