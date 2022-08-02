package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.repository.AccommodationRepository;

public class RoomAccommodationService extends AccommodationServiceImpl {

    public RoomAccommodationService(AccommodationRepository accommodationRepository) {
        super(accommodationRepository);
    }

    @Override
    public AccommodationType getAccommodationType() {
        return AccommodationType.ROOM;
    }

}
