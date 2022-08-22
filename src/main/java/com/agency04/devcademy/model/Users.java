package com.agency04.devcademy.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 200)
    private String firstName;

    @Size(max = 200)
    private String lastName;

    private String email;

    private String password;

    private boolean enabled;

    private boolean tokenExpired;

    private Timestamp created;

    private Timestamp updated;

    public Users() {
    }

    public Users(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @PrePersist
    private void onCreate() {
        created = new Timestamp(new Date().getTime());
    }

    @PreUpdate
    private void onUpdate() {
        updated = new Timestamp(new Date().getTime());
    }

}
