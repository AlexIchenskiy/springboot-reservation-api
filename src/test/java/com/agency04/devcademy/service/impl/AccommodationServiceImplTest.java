package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.repository.AccommodationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class AccommodationServiceImplTest {

    AccommodationServiceImpl accommodationService;

    @Mock
    AccommodationRepository accommodationRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        accommodationService = new AccommodationServiceImpl(accommodationRepository);
    }

    @Test
    public void findAll() {
        Accommodation accommodation = new Accommodation();

        accommodationService.save(accommodation);

        List<Accommodation> accommodations = accommodationService.findAll();

        when(accommodationRepository.findAll()).thenReturn(accommodations);

        assertEquals(accommodations.size(), 1);

        verify(accommodationRepository, times(1)).findAll();
    }

}