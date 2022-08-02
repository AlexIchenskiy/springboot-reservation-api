package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

@Service
public class MobileHomeAccommodationService extends AccommodationServiceImpl {

    public MobileHomeAccommodationService(AccommodationRepository accommodationRepository) {
        super(accommodationRepository);
    }

    @Override
    public AccommodationType getAccommodationType() {
        return AccommodationType.MOBILE_HOME;
    }

}
