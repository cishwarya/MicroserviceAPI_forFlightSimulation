package io.flightlog.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.flightlog.dao.DAO;

/**
 * The Class App.
 * This class initiate the execution 
 */
@ComponentScan("io.flightlog.controller")
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args); /* Startup the server and scan controllers and other MVC related tasks */ 
		DAO.initDB(); /* connect with mongoDB and create db object to application use */
	}
}
