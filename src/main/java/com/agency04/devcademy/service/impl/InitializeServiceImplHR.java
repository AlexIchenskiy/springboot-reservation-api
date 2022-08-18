package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.*;
import com.agency04.devcademy.repository.*;
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
@Profile("HR")
public class InitializeServiceImplHR implements InitializeService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationHistoryRepository reservationHistoryRepository;

    public InitializeServiceImplHR() {
    }

    @Override
    public void initDatabase() {
        Location location1 = new Location("Dubrovnik", "Grad Dubrovnik", 20000);
        Location location2 = new Location("Mljet", "Otok Mljet", 20224);

        File dubrovnik = new File("src/main/resources/images/Dubrovnik.jpg");
        File mljet = new File("src/main/resources/images/Mljet.jpg");

        log.info("\nPreducitavanje " + this.locationRepository.save(location1));
        log.info("Preducitavanje " + this.locationRepository.save(location2) + "\n");

        Accommodation accommodation1 = new Accommodation("Sobe u Dubrovniku", "Grad",
                "Hrvatski kulturni dragulj", AccommodationType.ROOM,
                5, 4,
                dubrovnik,
                false, 450.0, location1);
        Accommodation accommodation2 = new Accommodation("Apartmani na Mljetu", "Otok",
                "Najljepši i najšumovitiji otok Jadrana", AccommodationType.APARTMENT,
                5, 5,
                mljet,
                false, 250.0, location2);

        log.info("\nPreducitavanje " + this.accommodationRepository.save(accommodation1));
        log.info("Preducitavanje " + this.accommodationRepository.save(accommodation2) + "\n");

        Users user = new Users("Obican", "Covjek", "obican.covjek@fer.hr");

        log.info("\nPreducitavanje " + this.usersRepository.save(user) + "\n");

        Reservation reservation = new Reservation(accommodation1,
                user,
                ReservationType.TEMPORARY, new Timestamp(new Date(2023, Calendar.AUGUST, 8).getTime()),
                new Timestamp(new Date(2023, Calendar.SEPTEMBER, 8).getTime()), 3, true);

        log.info("\nPreducitavanje " + this.reservationRepository.save(reservation) + "\n");

        ReservationHistory reservationHistory = new ReservationHistory(List.of(reservation),
                new Timestamp(new Date(2023, Calendar.AUGUST, 8).getTime()), ReservationType.TEMPORARY,
                ReservationType.TEMPORARY);

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
