package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.model.ReservationHistory;
import com.agency04.devcademy.repository.ReservationHistoryRepository;
import com.agency04.devcademy.service.ReservationHistoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationHistoryServiceImpl implements ReservationHistoryService {

    private ReservationHistoryRepository reservationHistoryRepository;

    public ReservationHistoryServiceImpl(@Qualifier("reservationHistoryRepository")
                                                 ReservationHistoryRepository reservationHistoryRepository) {
        this.reservationHistoryRepository = reservationHistoryRepository;
    }

    @Override
    public ReservationHistory get() {
        return reservationHistoryRepository.findAll().get(0);
    }

    @Override
    public ReservationHistory add(Reservation newReservation) {
        ReservationHistory reservationHistory = reservationHistoryRepository.findAll().get(0);

        List<Reservation> newReservations = reservationHistory.getReservationList();
        newReservations.add(newReservation);

        reservationHistory.setReservationList(newReservations);

        return reservationHistoryRepository.save(reservationHistory);
    }

}
