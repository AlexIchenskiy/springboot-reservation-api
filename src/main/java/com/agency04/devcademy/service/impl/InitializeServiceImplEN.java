package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.*;
import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.repository.ReservationHistoryRepository;
import com.agency04.devcademy.service.InitializeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Profile("EN")
public class InitializeServiceImplEN implements InitializeService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private ReservationHistoryRepository reservationHistoryRepository;

    public InitializeServiceImplEN() {
    }

    @Override
    public void initDatabase() {
        Location location1 = new Location("Krk", "Krk island", 51500);
        Location location2 = new Location("Hvar", "Hvar island", 21450);

        File krk = new File("src/main/resources/images/Krk.jpg");
        File hvar = new File("src/main/resources/images/Hvar.jpg");

        Accommodation accommodation1 = new Accommodation("Krk apartments", "Island",
                "The largest island in Croatia", AccommodationType.APARTMENT,
                4, 2, krk,
                true, 150.0, location1);
        Accommodation accommodation2 = new Accommodation("Hvar rooms", "Island",
                "The queen of the Croatian Dalmatian islands", AccommodationType.ROOM,
                5, 4, hvar,
                false, 200.0, location2);

        Users user = new Users("Regular", "Man", "regular.man@regular-mail.com");

        Reservation reservation = new Reservation(accommodation1,
                user,
                ReservationType.TEMPORARY, new Timestamp(new Date(2022, Calendar.AUGUST, 10).getTime()),
                new Timestamp(new Date(2022, Calendar.AUGUST, 24).getTime()), 2, true);

        ReservationHistory reservationHistory = new ReservationHistory(List.of(reservation),
                new Timestamp(new Date(2022, Calendar.AUGUST, 10).getTime()), ReservationType.TEMPORARY,
                ReservationType.TEMPORARY);

        log.info("Preloading " + this.accommodationRepository.save(accommodation2));

        log.info("\nPreloading " + this.reservationHistoryRepository.save(reservationHistory) + "\n");

        List<Accommodation> listOfAccommodations = accommodationRepository.findByCategorizationAndPersonCountGreaterThanEqual(3, 5);

        if (listOfAccommodations.size() == 0) {
            log.info("No accommodations with 3 stars and at least 5 beds :(");
        } else {
            log.info("Here are all accommodations with 3 stars and at least 5 beds: " +
                    listOfAccommodations);
        }
    }

}
