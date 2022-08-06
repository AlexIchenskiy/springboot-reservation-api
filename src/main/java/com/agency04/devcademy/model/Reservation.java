package com.agency04.devcademy.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    @NotNull
    private Accommodation accommodation;

    // private ReservationType reservationType;

    @NotNull
    private Timestamp checkIn;

    @NotNull
    private Timestamp checkOut;

    @NotNull
    private Integer personsCount;

    @NotNull
    private Boolean submitted;

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public Timestamp getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    public Timestamp getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getPersonsCount() {
        return personsCount;
    }

    public void setPersonsCount(Integer personsCount) {
        this.personsCount = personsCount;
    }

    public Boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
    }
}
