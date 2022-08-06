package com.agency04.devcademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id")
    @NotNull
    private Reservation reservation;

    private Timestamp entryTimestamp;

    private ReservationType fromType;

    private ReservationType toType;

    private Timestamp created;

    private Timestamp updated;

    public ReservationHistory() {
    }

    public ReservationHistory(Reservation reservation, Timestamp entryTimestamp, ReservationType fromType,
                              ReservationType toType) {
        this.reservation = reservation;
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

    public Long getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Timestamp getEntryTimestamp() {
        return entryTimestamp;
    }

    public void setEntryTimestamp(Timestamp entryTimestamp) {
        this.entryTimestamp = entryTimestamp;
    }

    public ReservationType getFromType() {
        return fromType;
    }

    public void setFromType(ReservationType fromType) {
        this.fromType = fromType;
    }

    public ReservationType getToType() {
        return toType;
    }

    public void setToType(ReservationType toType) {
        this.toType = toType;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationHistory that = (ReservationHistory) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ReservationHistory{" +
                "id=" + id +
                ", reservation=" + reservation +
                ", entryTimestamp=" + entryTimestamp +
                ", fromType=" + fromType +
                ", toType=" + toType +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

}
