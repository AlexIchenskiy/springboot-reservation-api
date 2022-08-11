package com.agency04.devcademy.config;

import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.service.impl.AccommodationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccommodationServiceConfig {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Bean("roomAccommodationService")
    AccommodationServiceImpl accommodationService() {
        return new AccommodationServiceImpl(accommodationRepository);
    }

}
