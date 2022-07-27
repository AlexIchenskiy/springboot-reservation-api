package com.agency04.devcademy.exception;

public class AccommodationNotFoundException extends RuntimeException {

    public AccommodationNotFoundException(Long id) {
        super("Could not find accommodation of id " + id);
    }

}
