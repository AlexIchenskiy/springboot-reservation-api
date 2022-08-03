package com.agency04.devcademy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateLocationException extends RuntimeException {

    public DuplicateLocationException() {
        super("This location already exists");
    }

}
