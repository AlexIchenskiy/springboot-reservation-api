package com.agency04.devcademy.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    @NotNull
    private Accommodation accommodation;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    @NotNull
    private Users users;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private ReservationType reservationType;

    @NotNull
    private Timestamp checkIn;

    @NotNull
    private Timestamp checkOut;

    @NotNull
    private Integer personsCount;

    @NotNull
    private Boolean submitted;

    private Timestamp created;

    private Timestamp updated;

    public Reservation() {
    }

    public Reservation(Accommodation accommodation, Users users, ReservationType reservationType, Timestamp checkIn,
                       Timestamp checkOut, Integer personsCount, Boolean submitted) {
        this.accommodation = accommodation;
        this.users = users;
        this.reservationType = reservationType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.personsCount = personsCount;
        this.submitted = submitted;
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
