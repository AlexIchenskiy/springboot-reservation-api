package com.agency04.devcademy.form;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.ReservationType;
import com.agency04.devcademy.model.Users;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
public class ReservationForm {

    private Long id;

    @NotNull
    private Accommodation accommodation;

    @NotNull
    private Users users;

    @NotNull
    private ReservationType reservationType;

    @NotNull
    private Timestamp checkIn;

    @NotNull
    private Timestamp checkOut;

    @NotNull
    private Integer personsCount;

    @NotNull
    private Boolean submitted;

}
