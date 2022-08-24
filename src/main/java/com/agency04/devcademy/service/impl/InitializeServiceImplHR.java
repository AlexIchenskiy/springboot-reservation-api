package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.*;
import com.agency04.devcademy.repository.*;
import com.agency04.devcademy.service.InitializeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

        log.info("Preducitavanje " + this.locationRepository.save(location1));
        log.info("Preducitavanje " + this.locationRepository.save(location2));

        Accommodation accommodation1 = new Accommodation("Sobe u Dubrovniku", "Grad",
                "Hrvatski kulturni dragulj", AccommodationType.ROOM,
                5, 4, false, 450.0, location1);
        Accommodation accommodation2 = new Accommodation("Apartmani na Mljetu", "Otok",
                "Najljepši i najšumovitiji otok Jadrana", AccommodationType.APARTMENT,
                5, 5, false, 250.0, location2);

        log.info("\nPreducitavanje " + this.accommodationRepository.save(accommodation1));
        log.info("Preducitavanje " + this.accommodationRepository.save(accommodation2) + "\n");

        Users user1 = new Users("Obican", "Covjek", "obican.covjek@fer.hr", "lozinka",
                Set.of(new SimpleGrantedAuthority("USER")));
        Users user2 = new Users("Obican", "Admin", "obican.admin@fer.hr", "admin",
                Set.of(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("ADMIN")));

        log.info("Preducitavanje " + this.usersRepository.save(user1));
        log.info("Preducitavanje " + this.usersRepository.save(user2));

        Reservation reservation = new Reservation(accommodation1,
                user1,
                ReservationType.TEMPORARY, new Timestamp(new Date(2023, Calendar.AUGUST, 8).getTime()),
                new Timestamp(new Date(2023, Calendar.SEPTEMBER, 8).getTime()), 3, true);

        log.info("Preducitavanje " + this.reservationRepository.save(reservation));

        ReservationHistory reservationHistory = new ReservationHistory(List.of(reservation),
                new Timestamp(new Date(2023, Calendar.AUGUST, 8).getTime()), ReservationType.TEMPORARY,
                ReservationType.TEMPORARY);

        log.info("Preducitavanje " + this.reservationHistoryRepository.save(reservationHistory));

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
