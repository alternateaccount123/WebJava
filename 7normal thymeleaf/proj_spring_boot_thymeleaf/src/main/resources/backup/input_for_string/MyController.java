package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//string input 
//<1> add input from form in html that sends post request
//<2> add java method to handle post request 
@Controller // when working with thymeleaf use controller 
@RequestMapping(path = "/example") //URL's start with /example (after Application path) all methods default to this 
public class MyController {
	
	
	//constructor injection 
	private PersonService personService;
	public MyController(PersonService personService) {  	
		super();
		this.personService = personService;
	}
	
		
	//will always be called before any request handler method that returns the "mainpage" view. including redirects
    @ModelAttribute  
    public void loadPage(Model model) {
        Person person = personService.findById(1L).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("myvariable", person);
    }
    
	//handle get request to http://localhost:8080/example 
    @GetMapping
    public String handleGetRequest(Model model) {
        return "mainpage";
    }
	
    
    //<2> make post method for string input 
	//handle post request from http://localhost:8080/example 
    @PostMapping
    public String handleFormSubmission(Model model, String stringinput) {
    	
        // Use the stringinput value as needed
    	System.out.println(stringinput);
    	model.addAttribute("mystringvar", stringinput);  //put 'stringinput' value from java code into thymeleaf variable 'mystringvar'

    	return "mainpage";  //updates mainpage with data from this method model
    	//return "redirect:/example";   //updates /example but it will redirect to other method losing all model data gotten here i.e. stringinput 
      
    }
    
    
}
    



