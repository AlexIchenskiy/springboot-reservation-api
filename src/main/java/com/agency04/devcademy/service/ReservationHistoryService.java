package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.model.ReservationHistory;

public interface ReservationHistoryService {

    ReservationHistory get();
    ReservationHistory add(Reservation newReservation);

}
