package com.agency04.devcademy.form;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@MappedSuperclass
public class DescriptionForm {

    @Size(max = 100)
    @NotNull(message = "{NotNull}")
    protected String title;

    @Size(max = 150)
    @NotNull(message = "{NotNull}")
    protected String subtitle;

}
