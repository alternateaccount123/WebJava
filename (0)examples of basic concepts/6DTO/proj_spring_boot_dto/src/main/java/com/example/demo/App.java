package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//DTO
//<1> make a copy of entity class with no anottations (here is PersonDto)
//<2>implement methods (this example only needs the convertToDto method)
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
