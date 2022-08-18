package com.agency04.devcademy.form;

import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.model.Location;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.File;

@Getter
@Setter
public class AccommodationForm extends DescriptionForm {

    @NotNull
    private String description;

    @NotNull
    private AccommodationType type;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer categorization;

    @Min(1)
    private Integer personCount;

    private Byte[] image;

    private boolean freeCancelation = true;

    @NotNull
    private Double price;

    @NotNull
    private Long locationId;

}
