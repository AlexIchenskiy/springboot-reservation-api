package com.agency04.devcademy.service;

import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.repository.AccommodationRepository;
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
        switch (accommodationType) {
            case ROOM: return new RoomAccommodationService(accommodationRepository);
            case APARTMENT: return new ApartmentAccommodationService(accommodationRepository);
            case MOBILE_HOME: return new MobileHomeAccommodationService(accommodationRepository);
            default: return new RoomAccommodationService(accommodationRepository);
        }
    }

    public AccommodationService getAccommodationService() {
        return new RoomAccommodationService(accommodationRepository);
    }

}
