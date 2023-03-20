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

//PRINT_OBJ_OR_LIST_OBJ
//<1> add table in html that prints elements from a list
//<2> send java list object to Model obj
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
    	
    	/*
		//example with only 1 person obj 
		Person person = personService.findById(1L).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));   	
        model.addAttribute("myvariable", person);  //<2>
		*/
    	
    	//example with a list of person objects
        Iterable<Person> peopleIterable = personService.findAll();  //get all data from db and put into iterable obj 
        List<Person> people = new ArrayList<>();   //make list 
        peopleIterable.forEach(p -> people.add(p));//populate list
        model.addAttribute("myvariable", people);   //<2>set a value for the thymeleaf variable "${myvariable}" in the html.   
        
        
    }  
	//handle get request to http://localhost:8080/example 
    @GetMapping
    public String handleGetRequest(Model model) {
        return "mainpage";
    }
	



    
}
    



