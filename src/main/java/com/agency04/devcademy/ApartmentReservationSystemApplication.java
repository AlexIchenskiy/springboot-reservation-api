package com.agency04.devcademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.agency04.devcademy")
public class ApartmentReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentReservationSystemApplication.class, args);
	}

}
