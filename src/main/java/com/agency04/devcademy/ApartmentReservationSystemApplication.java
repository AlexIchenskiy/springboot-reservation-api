package com.agency04.devcademy;

import com.agency04.devcademy.controller.AccommodationController;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@EnableJpaRepositories("com.agency04.devcademy")
public class ApartmentReservationSystemApplication {

	@Autowired
	private AccommodationRepository accommodationRepository;

	@Autowired
	private ConfigurableEnvironment env;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ApartmentReservationSystemApplication.class, args);

		ConfigurableEnvironment env = ctx.getEnvironment();

		AccommodationController accommodationController = (AccommodationController) ctx.getBean("accommodationController");

		System.out.println("Controller initialized");
	}

	@PostConstruct
	void initDB() {
		Accommodation accommodation1 = new Accommodation();
		Accommodation accommodation2 = new Accommodation();
		if (Arrays.asList(env.getActiveProfiles()).contains("EN")) {
			System.out.println("Preloading " + this.accommodationRepository.save(accommodation1));
			System.out.println("Preloading " + this.accommodationRepository.save(accommodation2));
		} else if (Arrays.asList(env.getActiveProfiles()).contains("HR")) {
			System.out.println("Preducitavanje " + this.accommodationRepository.save(accommodation1));
			System.out.println("Preducitavanje " + this.accommodationRepository.save(accommodation2));
		}
	}

}
