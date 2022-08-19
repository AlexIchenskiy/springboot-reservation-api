package com.agency04.devcademy.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class DescriptionDTO {

    protected String title;

    protected String subtitle;

}
