package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.service.InitializeService;
import org.springframework.beans.factory.annotation.Autowired;

public class InitializeServiceImplHR implements InitializeService {

    @Autowired
    AccommodationServiceImpl accommodationService;

    @Autowired
    LocationServiceImpl locationService;

    public InitializeServiceImplHR() {
    }

    @Override
    public void initDatabase() {
        Location location1 = new Location("Dubrovnik", 20000);
        Location location2 = new Location("Mljet", 20224);

        Accommodation accommodation1 = new Accommodation("Sobe u Dubrovniku", "Grad",
                "Hrvatski kulturni dragulj", AccommodationType.ROOM,
                5, 4,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Montage_of_major_Dubrovnik_landmarks.jpg/420px-Montage_of_major_Dubrovnik_landmarks.jpg",
                false, 450.0, location1);
        Accommodation accommodation2 = new Accommodation("Apartmani na Mljetu", "Otok",
                "Najljepši i najšumovitiji otok Jadrana", AccommodationType.APARTMENT,
                5, 5,
                "http://visitdubrovnik.hr/wp-content/uploads/2018/09/shutterstock_1101003428-1024x761.jpg",
                false, 250.0, location2);

        System.out.println("\nPreducitavanje " + this.locationService.save(location1));
        System.out.println("Preducitavanje " + this.locationService.save(location2));

        System.out.println("\nPreducitavanje " + this.accommodationService.save(accommodation1));
        System.out.println("Preducitavanje " + this.accommodationService.save(accommodation2) + "\n");
    }
}
