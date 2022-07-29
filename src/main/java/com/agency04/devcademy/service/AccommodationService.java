package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Accommodation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccommodationService {

    Accommodation save(Accommodation accommodation);
    List<Accommodation> findAll();
    Accommodation findById(Long id);
    Accommodation update(Long id, Accommodation accommodationDetails);
    void deleteById(Long id);

}
