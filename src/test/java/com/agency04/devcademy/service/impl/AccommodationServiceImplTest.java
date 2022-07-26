package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.controller.AccommodationController;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.repository.LocationRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith({MockitoExtension.class})
@ActiveProfiles("TEST")
@ComponentScan(basePackageClasses = InitializeServiceImplTEST.class)
class AccommodationServiceImplTest {

    @InjectMocks
    AccommodationServiceImpl accommodationService;

    @Autowired
    AccommodationRepository accommodationRepository;

    @Autowired
    LocationRepository locationRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void initUseCase() {
        accommodationService = new AccommodationServiceImpl(accommodationRepository);
    }

    @Test
    public void should_find_empty_list() {
        List<Accommodation> accommodations = accommodationService.findAll();

        Assertions.assertEquals(0, accommodations.size());
    }

    @Test
    public void should_find_list_with_one_element() throws Exception {
        File dubrovnik = new File("src/main/resources/images/Dubrovnik.jpg");

        Location location = locationRepository.save(new Location("A", "B", 1));

        Accommodation accommodation1 = new Accommodation("Sobe u Dubrovniku", "Grad",
                "Hrvatski kulturni dragulj", AccommodationType.ROOM,
                5, 4,
                false, 450.0, location);

        Accommodation accommodation = accommodationService.save(accommodation1);

        System.out.println(accommodation);

        Assertions.assertEquals(1, accommodationService.findAll().size());
    }

}