package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




//SERVICES
//<1> new field and constructor injection in controller
//<2> add service "PersonService" to implement business logic from repository interface
//<3> inside controllere test by using a PersonService method "findById" to retrieve data from the database
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
