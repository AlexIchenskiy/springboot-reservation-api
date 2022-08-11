package com.agency04.devcademy;

import com.agency04.devcademy.service.InitializeService;
import com.agency04.devcademy.service.impl.InitializeServiceImplTEST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories("com.agency04.devcademy")
public class ApartmentReservationSystemApplication {

	@Autowired
	private InitializeService initializeService;

	public static void main(String[] args) {
		//ConfigurableApplicationContext ctx =
		SpringApplication.run(ApartmentReservationSystemApplication.class, args);
	}

	@PostConstruct
	void initDatabase() {
		initializeService.initDatabase();
	}

}
