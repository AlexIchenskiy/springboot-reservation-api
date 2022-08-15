package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation save(Reservation reservation);
    List<Reservation> findAll();
    Reservation findById(Long id);
    Reservation update(Long id, Reservation ReservationDetails);
    void deleteById(Long id);

}
