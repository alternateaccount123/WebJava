package com.example.SpringFromZero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//for <1> use a RestController for test
//for <2> and up , use a Controller for test 
@Controller
@RequestMapping(value = "/example")
public class MyController {
	
	
	//<3>
    @Autowired // bean injection , you could also use constructor injection , they are equivalent
    private PersonRepository personRepository;   
    //<3>
    //run on browser -> localhost:8080/example
	@GetMapping
	public String getAllUsers(Model model) {	
		//save into database 
		Person n = new Person("nothing", "5530273");		
		personRepository.save(n);  		
		//find person by id and return it //.get(0) because it retrieves a list of results like a query
		Person person = personRepository.findByFirstName("nothing").get(0);  //.get (0) means first index from list
		model.addAttribute("myvariable", person); 
		return "mainpage";
		
	}
    
    
    /*
    //<2>
    //run on browser -> localhost:8080/example
    @GetMapping
    public String getProjects(Model model) {   	   		
    	//sending an String object to html 
        model.addAttribute("myvariable", "Hello world");    // set attribute for model, first arg is thy var
        return "mainpage";       //by using @Controller the return statement. makes sure that the "mainpage.html" file can access the model attributes
    }
	*/
	
	/*
	//<1>
	//run on browser -> localhost:8080/example
	//output is json representation of object i.e. 
	//for a String output is "hello world" 
	//for an Object instance output is {"brand":"toyota","year":2000}
    @GetMapping
    public String myMethod() {
        return "Hello World";  //by using @RestController the method retusn json by default
    }
    */
    
    
    
}
