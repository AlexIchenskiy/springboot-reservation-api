package com.agency04.devcademy.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class Description {

    protected String title;

    protected String subtitle;

    public Description() {
    }

    public Description(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

}
