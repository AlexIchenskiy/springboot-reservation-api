package com.agency04.devcademy.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginForm {

    @NotNull(message = "{NotNull}")
    private String email;

    @NotNull(message = "{NotNull}")
    private String password;

}
