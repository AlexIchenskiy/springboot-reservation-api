package com.agency04.devcademy.config;

import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.service.impl.RoomAccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccommodationServiceConfig {

    @Autowired
    AccommodationRepository accommodationRepository;

    @Bean("roomAccommodationService")
    RoomAccommodationService roomAccommodationService() {
        return new RoomAccommodationService(accommodationRepository);
    }

}
