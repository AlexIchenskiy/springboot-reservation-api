package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.*;
import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.repository.ReservationHistoryRepository;
import com.agency04.devcademy.repository.ReservationRepository;
import com.agency04.devcademy.repository.UsersRepository;
import com.agency04.devcademy.service.InitializeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class InitializeServiceImplHR implements InitializeService {

    @Autowired
    AccommodationServiceImpl accommodationService;

    @Autowired
    AccommodationRepository accommodationRepository;

    @Autowired
    LocationServiceImpl locationService;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationHistoryRepository reservationHistoryRepository;

    public InitializeServiceImplHR() {
    }

    @Override
    public void initDatabase() {
        Location location1 = new Location("Dubrovnik", "Grad Dubrovnik", 20000);
        Location location2 = new Location("Mljet", "Orok Mljet", 20224);

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

        Users user = new Users("Obican", "Covjek", "obican.covjek@fer.hr");

        Reservation reservation = new Reservation(accommodation1,
                user,
                ReservationType.TEMPORARY, new Timestamp(new Date(2022, 7, 8).getTime()),
                new Timestamp(new Date(2022, 8, 8).getTime()), 3, true);

        ReservationHistory reservationHistory = new ReservationHistory(List.of(reservation),
                new Timestamp(new Date(2022, 7, 8).getTime()), ReservationType.TEMPORARY,
                ReservationType.TEMPORARY);

        System.out.println("\nPreducitavanje " + this.locationService.save(location1));
        System.out.println("Preducitavanje " + this.locationService.save(location2));

        System.out.println("\nPreducitavanje " + this.accommodationService.save(accommodation1));
        System.out.println("Preducitavanje " + this.accommodationService.save(accommodation2));

        System.out.println("\nPreducitavanje " + this.usersRepository.save(user));

        System.out.println("\nPreducitavanje " + this.reservationRepository.save(reservation));

        System.out.println("\nPreducitavanje " + this.reservationHistoryRepository.save(reservationHistory) + "\n");

        List<Optional<Accommodation>> listOfAccommodations = accommodationRepository.findByCategorizationAndPersonCountGreaterThan(3, 5);

        if (listOfAccommodations.size() == 0) {
            System.out.println("Nema smjestaja s 3 zvijezde i minimalno 5 kreveta :(");
        } else {
            System.out.println("Svi smjestaji s 3 zvijezde i minimalno 5 kreveta: " +
                    listOfAccommodations);
        }

    }
}
