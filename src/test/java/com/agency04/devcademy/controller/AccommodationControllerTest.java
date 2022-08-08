package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.impl.AccommodationServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AccommodationControllerTest {

    @Mock
    AccommodationServiceImpl accommodationService;

    @Autowired
    @Mock
    AccommodationController accommodationController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        accommodationController = new AccommodationController(accommodationService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(accommodationController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/accommodation"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void recommendation() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(accommodationController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/accommodation/recommendation"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}