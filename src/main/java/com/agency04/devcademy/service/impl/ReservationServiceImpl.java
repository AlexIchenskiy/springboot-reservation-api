package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.exception.ReservationNotFoundException;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.repository.ReservationRepository;
import com.agency04.devcademy.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationHistoryServiceImpl reservationHistoryService;

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(@Qualifier("reservationRepository") ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @Override
    public Reservation update(Long id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));

        reservation.setAccommodation(reservationDetails.getAccommodation());
        reservation.setUsers(reservationDetails.getUsers());
        reservation.setReservationType(reservationDetails.getReservationType());
        reservation.setCheckIn(reservationDetails.getCheckIn());
        reservation.setCheckOut(reservationDetails.getCheckOut());
        reservation.setPersonsCount(reservationDetails.getPersonsCount());
        reservation.setSubmitted(reservationDetails.getSubmitted());

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation confirm(Long id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));

        reservation.setAccommodation(reservationDetails.getAccommodation());
        reservation.setUsers(reservationDetails.getUsers());
        reservation.setReservationType(reservationDetails.getReservationType());
        reservation.setCheckIn(reservationDetails.getCheckIn());
        reservation.setCheckOut(reservationDetails.getCheckOut());
        reservation.setPersonsCount(reservationDetails.getPersonsCount());
        reservation.setSubmitted(true);

        reservationHistoryService.add(reservationDetails);

        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

}
