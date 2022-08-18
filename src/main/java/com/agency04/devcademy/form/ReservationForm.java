package com.agency04.devcademy.form;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.ReservationType;
import com.agency04.devcademy.model.Users;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
public class ReservationForm {

    @NotNull
    private Long accommodationId;

    @NotNull
    private Long usersId;

    @NotNull
    private ReservationType reservationType;

    @Future
    @NotNull
    private Timestamp checkIn;

    @Future
    @NotNull
    private Timestamp checkOut;

    @NotNull
    @Min(1)
    private Integer personsCount;

    @NotNull
    private Boolean submitted;

}
