package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartmentAccommodationService extends AccommodationServiceImpl {
    public ApartmentAccommodationService(AccommodationRepository accommodationRepository) {
        super(accommodationRepository);
    }
}
