package com.agency04.devcademy.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id")
    @NotNull
    private List<Reservation> reservationList;

    private Timestamp entryTimestamp;

    @Enumerated(EnumType.ORDINAL)
    private ReservationType fromType;

    @Enumerated(EnumType.ORDINAL)
    private ReservationType toType;

    private Timestamp created;

    private Timestamp updated;

    public ReservationHistory() {
    }

    public ReservationHistory(List<Reservation> reservationList, Timestamp entryTimestamp, ReservationType fromType,
                              ReservationType toType) {
        this.reservationList = reservationList;
        this.entryTimestamp = entryTimestamp;
        this.fromType = fromType;
        this.toType = toType;
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
