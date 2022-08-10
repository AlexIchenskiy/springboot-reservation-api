package com.agency04.devcademy.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
public class Accommodation extends Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private AccommodationType type;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer categorization;

    @Min(1)
    private Integer personCount;

    private String imageUrl;

    private boolean freeCancelation = true;

    @NotNull
    private Double price;

    private Timestamp created;

    private Timestamp updated;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    @NotNull
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Accommodation() {
    }

    public Accommodation(String title, String subtitle, String description,
                         AccommodationType type, Integer categorization, Integer personCount, String imageUrl,
                         boolean freeCancelation, Double price, Location location) {
        super(title, subtitle);
        this.description = description;
        this.type = type;
        this.categorization = categorization;
        this.personCount = personCount;
        this.imageUrl = imageUrl;
        this.freeCancelation = freeCancelation;
        this.price = price;
        this.location = location;
    }

    @PrePersist
    private void onCreate() {
        created = new Timestamp(new Date().getTime());
    }

    @PreUpdate
    private void onUpdate() {
        updated = new Timestamp(new Date().getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accommodation that = (Accommodation) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
