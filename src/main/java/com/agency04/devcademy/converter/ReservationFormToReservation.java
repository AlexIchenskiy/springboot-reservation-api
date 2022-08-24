package com.agency04.devcademy.converter;

import com.agency04.devcademy.form.ReservationForm;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.service.impl.AccommodationServiceImpl;
import com.agency04.devcademy.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReservationFormToReservation implements Converter<ReservationForm, Reservation> {

    @Autowired
    private AccommodationServiceImpl accommodationService;

    @Autowired
    private UsersServiceImpl usersService;

    public Reservation convert(ReservationForm reservationDetails) {
        final Reservation reservation = new Reservation();

        reservation.setAccommodation(accommodationService.findById(reservationDetails.getAccommodationId()));
        reservation.setUsers(usersService.findById(reservationDetails.getUsersId()));
        reservation.setReservationType(reservationDetails.getReservationType());
        reservation.setCheckIn(reservationDetails.getCheckIn());
        reservation.setCheckOut(reservationDetails.getCheckOut());
        reservation.setPersonsCount(reservationDetails.getPersonsCount());
        reservation.setSubmitted(false);

        return reservation;
    }

}
