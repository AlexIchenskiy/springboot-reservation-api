package com.agency04.devcademy.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 100)
    private String title;

    @Size(max = 200)
    private String subtitle;

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
        this.title = title;
        this.subtitle = subtitle;
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

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccommodationType getType() {
        return type;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }

    public Integer getCategorization() {
        return categorization;
    }

    public void setCategorization(Integer categorization) {
        this.categorization = categorization;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFreeCancelation() {
        return freeCancelation;
    }

    public void setFreeCancelation(boolean freeCancelation) {
        this.freeCancelation = freeCancelation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

        Accommodation that = (Accommodation) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", categorization=" + categorization +
                ", personCount=" + personCount +
                ", imageUrl='" + imageUrl + '\'' +
                ", freeCancelation=" + freeCancelation +
                ", price=" + price +
                ", created=" + created +
                ", updated=" + updated +
                ", location=" + location +
                '}';
    }

}
