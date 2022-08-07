package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.*;
import com.agency04.devcademy.repository.ReservationHistoryRepository;
import com.agency04.devcademy.repository.ReservationRepository;
import com.agency04.devcademy.repository.UsersRepository;
import com.agency04.devcademy.service.InitializeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class InitializeServiceImplEN implements InitializeService {

    @Autowired
    AccommodationServiceImpl accommodationService;

    @Autowired
    LocationServiceImpl locationService;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationHistoryRepository reservationHistoryRepository;

    public InitializeServiceImplEN() {
    }

    @Override
    public void initDatabase() {
        Location location1 = new Location("Krk", "Krk island", 51500);
        Location location2 = new Location("Hvar", "Hvar island", 21450);

        Accommodation accommodation1 = new Accommodation("Krk apartments", "Island",
                "The largest island in Croatia", AccommodationType.APARTMENT,
                4, 2, "https://www.aurea-krk.com/resources/images/hrvatska-krk/krk-town-2.jpg",
                true, 150.0, location1);
        Accommodation accommodation2 = new Accommodation("Hvar rooms", "Island",
                "The queen of the Croatian Dalmatian islands", AccommodationType.ROOM,
                5, 4, "https://www.hvarinfo.com/images/hvar7.jpg",
                false, 200.0, location2);

        Users user = new Users("Regular", "Man", "regular.man@regular-mail.com");

        Reservation reservation = new Reservation(accommodation1,
                user,
                ReservationType.TEMPORARY, new Timestamp(new Date(2022, 7, 10).getTime()),
                new Timestamp(new Date(2022, 7, 24).getTime()), 2, true);

        ReservationHistory reservationHistory = new ReservationHistory(List.of(reservation),
                new Timestamp(new Date(2022, 7, 10).getTime()), ReservationType.TEMPORARY,
                ReservationType.TEMPORARY);

        System.out.println("\nPreloading " + this.locationService.save(location1));
        System.out.println("Preloading " + this.locationService.save(location2));

        System.out.println("\nPreloading " + this.accommodationService.save(accommodation1));
        System.out.println("Preloading " + this.accommodationService.save(accommodation2));

        System.out.println("\nPreloading " + this.usersRepository.save(user));

        System.out.println("\nPreloading " + this.reservationRepository.save(reservation));

        System.out.println("\nPreloading " + this.reservationHistoryRepository.save(reservationHistory) + "\n");
    }

}
