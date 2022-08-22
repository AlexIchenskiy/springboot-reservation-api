package com.agency04.devcademy.exception;

public class UsersNotFoundException extends RuntimeException {

    public UsersNotFoundException() {
        super("Could not find user with those credentials");
    }

    public UsersNotFoundException(Long id) {
        super("Could not find user of id " + id);
    }

    public UsersNotFoundException(String email) {
        super("Could not find user of email " + email);
    }

}
