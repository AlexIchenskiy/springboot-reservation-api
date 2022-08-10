package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.*;
import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.repository.ReservationHistoryRepository;
import com.agency04.devcademy.repository.ReservationRepository;
import com.agency04.devcademy.repository.UsersRepository;
import com.agency04.devcademy.service.InitializeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
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
        Location location2 = new Location("Mljet", "Otok Mljet", 20224);

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
                ReservationType.TEMPORARY, new Timestamp(new Date(2022, Calendar.AUGUST, 8).getTime()),
                new Timestamp(new Date(2022, Calendar.SEPTEMBER, 8).getTime()), 3, true);

        ReservationHistory reservationHistory = new ReservationHistory(List.of(reservation),
                new Timestamp(new Date(2022, Calendar.AUGUST, 8).getTime()), ReservationType.TEMPORARY,
                ReservationType.TEMPORARY);

        log.info("Preducitavanje " + this.accommodationService.save(accommodation2));

        log.info("\nPreducitavanje " + this.reservationHistoryRepository.save(reservationHistory) + "\n");

        List<Accommodation> listOfAccommodations =
                accommodationRepository.findByCategorizationAndPersonCountGreaterThanEqual(3, 5);

        if (listOfAccommodations.size() == 0) {
            log.info("Nema smjestaja s 3 zvijezde i minimalno 5 kreveta :(");
        } else {
            log.info("Svi smjestaji s 3 zvijezde i minimalno 5 kreveta: " +
                    listOfAccommodations);
        }

    }
}
