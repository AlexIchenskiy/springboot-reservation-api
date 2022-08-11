package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.service.InitializeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("TEST")
public class InitializeServiceImplTEST implements InitializeService {

    @Override
    public void initDatabase() {
        log.info("Database initialized");
    }

}
