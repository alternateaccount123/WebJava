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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//INPUT_FOR_OBJECTS
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
        //send empty person obj for the thymeleaf form to use, do this with all objects but strs
    	model.addAttribute("person", new Person()); 
        return "mainpage";
    }
	
    //<2>make post method for object input 
    //handle post request from http://localhost:8080/example 
    @PostMapping
    public String handleFormSubmission(Model model, Person person) {
    	
    	 // Use the object input value as needed
        System.out.println(person);
    	model.addAttribute("myobjinputvar", person);  //put 'person' value from java code into thymeleaf variable 'myobjinputvar'
    	
        return "redirect:/example";   //you must use return redirect
    	//return "mainpage";          //you must not use return myfile.html after a @post handler method . instead you use redirect    
    }
    

    
}
    



