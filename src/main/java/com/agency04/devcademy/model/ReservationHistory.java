package com.agency04.devcademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id")
    @NotNull
    private List<Reservation> reservationList;

    private Timestamp entryTimestamp;

    private ReservationType fromType;

    private ReservationType toType;

    private Timestamp created;

    private Timestamp updated;

    public ReservationHistory() {
    }

    public ReservationHistory(List<Reservation> reservationList, Timestamp entryTimestamp, ReservationType fromType,
                              ReservationType toType, Timestamp created, Timestamp updated) {
        this.reservationList = reservationList;
        this.entryTimestamp = entryTimestamp;
        this.fromType = fromType;
        this.toType = toType;
        this.created = created;
        this.updated = updated;
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

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
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
                ", reservationList=" + reservationList +
                ", entryTimestamp=" + entryTimestamp +
                ", fromType=" + fromType +
                ", toType=" + toType +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

}
