package com.agency04.devcademy.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class UsersForm {

    @Size(max = 200)
    private String firstName;

    @Size(max = 200)
    private String lastName;

    private String email;

}
