package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // This means that this class is a Controller
@RequestMapping(path = "/example") //URL's start with /example (after Application path)
public class MyController {
	
	
	//<1> new field and constructor injection 
	private PersonService personService;
	public MyController(PersonService personService) {  	
		super();
		this.personService = personService;
	}
	
	//@Autowired // get the bean called personService , you could also use constructor injection , they are equivalent
	//private PersonService personService;  

	
	//input personService.findById(1L)
	//output {"id":1,"firstName":"jon","lastName":"doe"}
	@GetMapping(path = "/1")
	public Person getAllUsers() {
		
		//save into database 
		Person n = new Person("messi", "ident");		
		personService.save(n);  //<3>
		
		//find person by id and return it 
		Person person = personService.findById(1L).get();   //<3>	
		return person;
	}
	
	
	
}


