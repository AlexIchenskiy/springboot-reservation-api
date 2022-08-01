package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.InitializeService;

public class InitializeServiceImplHR implements InitializeService {

    AccommodationService accommodationService;

    public InitializeServiceImplHR(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Override
    public void initDatabase() {
        Accommodation accommodation1 = new Accommodation("Sobe u Dubrovniku", "Grad",
                "Hrvatski kulturni dragulj", AccommodationType.ROOM,
                5, 4,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Montage_of_major_Dubrovnik_landmarks.jpg/420px-Montage_of_major_Dubrovnik_landmarks.jpg",
                false, 450.0);
        Accommodation accommodation2 = new Accommodation("Apartmani na Mljetu", "Otok",
                "Najljepši i najšumovitiji otok Jadrana", AccommodationType.APARTMENT,
                5, 5,
                "http://visitdubrovnik.hr/wp-content/uploads/2018/09/shutterstock_1101003428-1024x761.jpg",
                false, 250.0);
        System.out.println("Preducitavanje " + this.accommodationService.save(accommodation1));
        System.out.println("Preducitavanje " + this.accommodationService.save(accommodation2));
    }
}
