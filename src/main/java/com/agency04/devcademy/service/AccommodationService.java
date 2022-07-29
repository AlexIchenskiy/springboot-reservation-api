package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Accommodation;

import java.util.List;

public interface AccommodationService {

    Accommodation save(Accommodation accommodation);
    List<Accommodation> findAll();
    Accommodation findById(Long id);
    Accommodation update(Long id, Accommodation accommodationDetails);
    void deleteById(Long id);

}
