package com.agency04.devcademy.DTO;

import com.agency04.devcademy.model.AccommodationType;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class AccommodationDTO extends DescriptionDTO {

    private String description;

    private AccommodationType type;

    private Integer categorization;

    private Integer personCount;

    private File image;

    private boolean freeCancelation = true;

    private Double price;

    private LocationDTO location;

}
