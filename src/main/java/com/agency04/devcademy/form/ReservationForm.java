package com.agency04.devcademy.form;

import com.agency04.devcademy.model.ReservationType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
public class ReservationForm {

    @NotNull(message = "{NotNull}")
    private Long accommodationId;

    @NotNull(message = "{NotNull}")
    private Long usersId;

    @NotNull(message = "{NotNull}")
    private ReservationType reservationType;

    @Future(message = "{Future.reservation}")
    @NotNull(message = "{NotNull}")
    private Timestamp checkIn;

    @Future(message = "{Future.reservation}")
    @NotNull(message = "{NotNull}")
    private Timestamp checkOut;

    @NotNull(message = "{NotNull}")
    @Min(value = 1, message = "{Min.reservation.personsCount}")
    private Integer personsCount;

}
