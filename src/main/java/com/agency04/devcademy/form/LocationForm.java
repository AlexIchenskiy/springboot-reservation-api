package com.agency04.devcademy.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LocationForm extends DescriptionForm {

    @NotNull(message = "{NotNull}")
    private Integer postalCode;

}
