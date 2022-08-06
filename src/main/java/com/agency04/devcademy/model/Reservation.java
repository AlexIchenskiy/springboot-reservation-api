package com.agency04.devcademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    @NotNull
    private Accommodation accommodation;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    @NotNull
    private Users users;

    // private ReservationType reservationType;

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

    public Reservation(Accommodation accommodation, Users users, Timestamp checkIn, Timestamp checkOut,
                       Integer personsCount, Boolean submitted) {
        this.accommodation = accommodation;
        this.users = users;
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

    public Long getId() {
        return id;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

        Reservation that = (Reservation) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", accommodation=" + accommodation +
                ", users=" + users +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", personsCount=" + personsCount +
                ", submitted=" + submitted +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

}
