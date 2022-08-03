package com.agency04.devcademy.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDataSource {

    private String username;

    public ApplicationDataSource(@Value("${accommodation.owner.name}") String username) {
        this.username = username;

        System.out.println("Welcome " + username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
