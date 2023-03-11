package com.example.SpringFromZero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//<1>make rest controller and make a handler method that sends json to view 
//(its handler methods return json format by default, which will be display in respective view) 

//<2>make a controller and make a handler method that updates html template
//(use a Model instance inside your handler method to transfer the data from java to the view) 
//note that you must setup your html file with thymeleaf. located at src/main/resources/templates

//<3>make an entity and the respective entityRepository, inject the repository into the controller using anottation autowire
//once repository is injected (is basically now an instance variable of the controller now) you use its methods 
//note that you must setup your database connection for the repository to use.Located at src/main/resources/application.properties

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
