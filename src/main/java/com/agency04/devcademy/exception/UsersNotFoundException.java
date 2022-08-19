package com.agency04.devcademy.exception;

public class UsersNotFoundException extends RuntimeException {

    public UsersNotFoundException(Long id) {
        super("Could not find user of id " + id);
    }

}
