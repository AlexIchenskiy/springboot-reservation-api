package com.agency04.devcademy.converter;

import com.agency04.devcademy.form.ReservationForm;
import com.agency04.devcademy.model.Reservation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;

@ComponentScan
public class ReservationFormToReservation implements Converter<ReservationForm, Reservation> {

    public Reservation convert(ReservationForm reservationDetails) {
        final Reservation reservation = new Reservation();

        reservation.setAccommodation(reservationDetails.getAccommodation());
        reservation.setUsers(reservationDetails.getUsers());
        reservation.setReservationType(reservationDetails.getReservationType());
        reservation.setCheckIn(reservationDetails.getCheckIn());
        reservation.setCheckOut(reservation.getCheckOut());
        reservation.setPersonsCount(reservation.getPersonsCount());
        reservation.setSubmitted(reservation.getSubmitted());

        return reservation;
    }

}
