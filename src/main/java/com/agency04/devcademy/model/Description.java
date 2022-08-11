package com.agency04.devcademy.model;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
@Data
public class Description {

    @Size(max = 100)
    @NotNull
    protected String title;

    @Size(max = 150)
    @NotNull
    protected String subtitle;

    public Description() {
    }

    public Description(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

}
