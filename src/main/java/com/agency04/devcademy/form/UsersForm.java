package com.agency04.devcademy.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UsersForm {

    @Size(max = 200, message = "{Size}")
    @NotNull
    private String firstName;

    @Size(max = 200, message = "{Size}")
    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

}
