package com.agency04.devcademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "reservation_id")
    @NotNull
    private Reservation reservation;

    private Timestamp entryTimestamp;

    // private ReservationType fromType;

    // private ReservationType toType;

}
