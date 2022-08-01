package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.InitializeService;

public class InitializeServiceImplEN implements InitializeService {

    AccommodationService accommodationService;

    public InitializeServiceImplEN(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Override
    public void initDatabase() {
        Accommodation accommodation1 = new Accommodation("Krk apartments", "Island",
                "The largest island in Croatia", AccommodationType.APARTMENT,
                4, 2, "https://www.aurea-krk.com/resources/images/hrvatska-krk/krk-town-2.jpg",
                true, 150.0);
        Accommodation accommodation2 = new Accommodation("Hvar rooms", "Island",
                "The queen of the Croatian Dalmatian islands", AccommodationType.ROOM,
                5, 4, "https://www.hvarinfo.com/images/hvar7.jpg",
                false, 200.0);
        System.out.println("Preloading " + this.accommodationService.save(accommodation1));
        System.out.println("Preloading " + this.accommodationService.save(accommodation2));
    }

}
