package com.agency04.devcademy.controller;

import com.agency04.devcademy.service.impl.AccommodationServiceImpl;
import com.agency04.devcademy.service.impl.InitializeServiceImplTEST;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = InitializeServiceImplTEST.class)
class AccommodationControllerTest {

    @Mock
    AccommodationServiceImpl accommodationService;

    @InjectMocks
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