package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//THYMELEAF
//<1> make sure that you are using a Controller and not a RestController
//<2>set a value for the thymeleaf variable "${myvariable}" in the html. 
//<3> this is the name of the html page (the view to be rendered)
//<4> create html 
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
