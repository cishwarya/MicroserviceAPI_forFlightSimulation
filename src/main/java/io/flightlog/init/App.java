package io.flightlog.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.flightlog.dao.DAO;

@ComponentScan("io.flightlog.controller")
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		DAO.initDB();
	}
}
