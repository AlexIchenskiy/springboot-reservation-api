package com.agency04.devcademy.config;

import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.impl.InitializeServiceImplEN;
import com.agency04.devcademy.service.impl.InitializeServiceImplHR;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class InitializeServiceConfig {

    @Bean
    @Primary
    @Profile("EN")
    InitializeServiceImplEN initializeService(AccommodationService accommodationService) {
        return new InitializeServiceImplEN(accommodationService);
    }

    @Bean("initializeService")
    @Profile("HR")
    InitializeServiceImplHR initializeServiceImplHR(AccommodationService accommodationService) {
        return new InitializeServiceImplHR(accommodationService);
    }

}
