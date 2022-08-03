package com.agency04.devcademy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(Long id) {
        super("Could not find location of id " + id);
    }

}
