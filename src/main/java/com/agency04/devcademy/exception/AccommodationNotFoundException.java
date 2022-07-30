package com.agency04.devcademy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccommodationNotFoundException extends RuntimeException {

    public AccommodationNotFoundException(Long id) {
        super("Could not find accommodation of id " + id);
    }

}
