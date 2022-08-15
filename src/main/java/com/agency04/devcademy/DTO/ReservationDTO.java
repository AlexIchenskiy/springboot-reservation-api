package com.agency04.devcademy.DTO;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.ReservationType;
import com.agency04.devcademy.model.Users;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ReservationDTO {

    private Long id;

    private Accommodation accommodation;

    private Users users;

    private ReservationType reservationType;

    private Timestamp checkIn;

    private Timestamp checkOut;

    private Integer personsCount;

    private Boolean submitted;

}
