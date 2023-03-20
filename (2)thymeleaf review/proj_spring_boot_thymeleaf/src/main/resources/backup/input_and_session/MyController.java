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
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpSession;

//INPUT_AND_SESSION 
//<1> add input from form in html that sends post request 
//<2> add java method to handle post request 
//<3> add HttpSession session as argument in the parameters of handlers
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
    public String handleGetRequest(Model model, HttpSession session) {   //<3>
        //send empty person obj for the thymeleaf form to use, do this with all objects but strs
    	model.addAttribute("person", new Person()); 
    	
    	 Person session_person = (Person) session.getAttribute("myobjinputvarsession");// Retrieve the input from the session
    	 model.addAttribute("myobjinputvar", session_person);  //put 'stringinput' value from java code into thymeleaf variable 'mystringvar'
        return "mainpage";
    }
	
    //make post method for object input 
    //handle post request from http://localhost:8080/example 
    @PostMapping
    public String handleFormSubmission(Model model, Person person, HttpSession session) {  //<3>
    	
    	// Use the object input value as needed
        System.out.println(person);       //the value from the html input is now set into the field of this obj . i.e. firstname updated
        session.setAttribute("myobjinputvarsession", person);  //send  this obj for "session" to store (it now persist between handlers)
        //redirects means after this method does its stuff it will go to /example (model attributes will NOT persist between request  handlers)
        return "redirect:/example";       //best practice to use redirect with a post form 
    	//return "mainpage";              //without redirect it tells to reload html. ignoring any updates made to db during the session
    }
    

    
}
    


