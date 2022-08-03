package com.agency04.devcademy;

import com.agency04.devcademy.controller.AccommodationController;
import com.agency04.devcademy.datasource.ApplicationDataSource;
import com.agency04.devcademy.datasource.OwnerDataSource;
import com.agency04.devcademy.service.InitializeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories("com.agency04.devcademy")
public class ApartmentReservationSystemApplication {

	@Autowired
	InitializeService initializeService;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ApartmentReservationSystemApplication.class, args);
		ApplicationDataSource applicationDataSource = ctx.getBean(ApplicationDataSource.class);
		OwnerDataSource ownerDataSource = ctx.getBean(OwnerDataSource.class);

		AccommodationController accommodationController = (AccommodationController) ctx.getBean("accommodationController");

		System.out.println("Controller initialized\nWelcome " + applicationDataSource.getUsername());
	}

	@PostConstruct
	void initDatabase() {
		initializeService.initDatabase();
	}

}
