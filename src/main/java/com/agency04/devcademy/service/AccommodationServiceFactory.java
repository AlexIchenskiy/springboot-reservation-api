package com.agency04.devcademy.service;

import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.service.impl.AccommodationServiceImpl;
import com.agency04.devcademy.service.impl.ApartmentAccommodationService;
import com.agency04.devcademy.service.impl.MobileHomeAccommodationService;
import com.agency04.devcademy.service.impl.RoomAccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccommodationServiceFactory {

    @Autowired
    AccommodationRepository accommodationRepository;

    public AccommodationService getAccommodationService(AccommodationType accommodationType) {
        return switch (accommodationType) {
            case ROOM -> new RoomAccommodationService(accommodationRepository);
            case APARTMENT -> new ApartmentAccommodationService(accommodationRepository);
            case MOBILE_HOME -> new MobileHomeAccommodationService(accommodationRepository);
            default -> new AccommodationServiceImpl(accommodationRepository);
        };
    }

    public AccommodationService getAccommodationService() {
        return new RoomAccommodationService(accommodationRepository);
    }

}
