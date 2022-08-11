package com.agency04.devcademy;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.repository.AccommodationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class AccommodationRepositoryTest {

    @Autowired
    AccommodationRepository accommodationRepository;

    @Test
    public void should_find_accommodations_with_x_stars_and_more_than_y_beds() {

        Integer stars = 3;
        Integer beds = 5;

        List<Accommodation> accommodations = accommodationRepository.findByCategorizationAndPersonCountGreaterThanEqual(stars, beds);

        assertEquals(accommodationRepository.findAll().stream()
                .filter(a -> Objects.equals(a.getCategorization(), stars) && a.getPersonCount() >= 5)
                .toList(), accommodations);

    }

}
