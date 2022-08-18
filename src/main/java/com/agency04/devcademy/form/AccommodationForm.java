package com.agency04.devcademy.form;

import com.agency04.devcademy.model.AccommodationType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AccommodationForm extends DescriptionForm {

    @NotNull(message = "{NotNull}")
    private String description;

    @NotNull(message = "{NotNull}")
    private AccommodationType type;

    @NotNull(message = "{NotNull}")
    @Min(value = 1, message = "{Min.accommodationForm.categorization}")
    @Max(value = 5, message = "{Max.accommodationForm.categorization}")
    private Integer categorization;

    @Min(value = 1, message = "{Min.accommodationForm.personCount}")
    private Integer personCount;

    private Byte[] image;

    private boolean freeCancelation = true;

    @NotNull(message = "{NotNull}")
    private Double price;

    @NotNull(message = "{NotNull}")
    private Long locationId;

}
