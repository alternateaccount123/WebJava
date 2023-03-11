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

//obj input 
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
        //<2> send empty person obj for the thymeleaf form to use, do this with all objects but strs
    	model.addAttribute("person", new Person()); 
    }  
	//handle get request to http://localhost:8080/example 
    @GetMapping
    public String handleGetRequest(Model model) {
        return "mainpage";
    }
	
    //<3> make post method for object input 
    //handle post request from http://localhost:8080/example 
    @PostMapping
    public String handleFormSubmission(Model model, Person person) {
    	
    	 // Use the object input value as needed
        System.out.println(person);
    	model.addAttribute("myobjinputvar", person);  //put 'stringinput' value from java code into thymeleaf variable 'mystringvar'
    	
        //return "redirect:/example";   //redirect tell to reload html and excute java code for that endpoint again 
    	return "mainpage";              //without redirect it tells to reload html but does not handles the endpoint with java code again    
    }
    

    
}
    



