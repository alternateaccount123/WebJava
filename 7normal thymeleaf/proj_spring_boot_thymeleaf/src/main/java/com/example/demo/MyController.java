package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@Controller // <1> make sure that you are using a Controller and not a RestController
@RequestMapping(path = "/example") //URL's start with /example (after Application path)
public class MyController {
	
	
	private PersonService personService;
	public MyController(PersonService personService) {  	
		super();
		this.personService = personService;
	}
	
	//@Autowired // get the bean called userRepository , you could also use constructor injection , they are equivalent
	//private PersonRepository personRepository;  
	
	
	
	//http://localhost:8080/example
    @GetMapping
    public String getProjects(Model model) {
    	
    	/*
    	//example with a list of person objects
        Iterable<Person> peopleIterable = personService.findAll();  //get all data from db and put into iterable obj 
        List<Person> people = new ArrayList<>();   //make list 
        peopleIterable.forEach(p -> people.add(p));//populate list
        model.addAttribute("myvariable", people);   //<2>set a value for the thymeleaf variable "${myvariable}" in the html.   
        return "mainpage";  //<3> this is the name of the html page (the view to be rendered)
    	*/
    	
    	
		//example with only 1 person obj 
		Person person = personService.findById(1L).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));   	
        model.addAttribute("myvariable", person);  //<2>
        return "mainpage";  //<3>
    	

    }


	
}


