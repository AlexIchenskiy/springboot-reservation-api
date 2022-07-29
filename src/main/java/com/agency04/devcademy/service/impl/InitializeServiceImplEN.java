package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.InitializeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("EN")
public class InitializeServiceImplEN implements InitializeService {

    AccommodationService accommodationService;

    public InitializeServiceImplEN(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Override
    public void initDatabase() {
        Accommodation accommodation1 = new Accommodation();
        Accommodation accommodation2 = new Accommodation();
        System.out.println("Preloading " + this.accommodationService.save(accommodation1));
        System.out.println("Preloading " + this.accommodationService.save(accommodation2));
    }

}
