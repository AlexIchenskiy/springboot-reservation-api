package com.agency04.devcademy.DTO;

import com.agency04.devcademy.model.ReservationType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ReservationDTO {

    private AccommodationDTO accommodation;

    private UsersDTO users;

    private ReservationType reservationType;

    private Timestamp checkIn;

    private Timestamp checkOut;

    private Integer personsCount;

    private Boolean submitted;

}
