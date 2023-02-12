package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//THYMELEAF
//<1> make html and put in folder templates 
//<2> in java controller send object to model (model automatically sends this data to html)
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
