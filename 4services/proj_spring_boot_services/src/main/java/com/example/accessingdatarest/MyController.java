package com.example.accessingdatarest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // This means that this class is a Controller
@RequestMapping(path = "/example") //URL's start with /example (after Application path)
public class MyController {
	
	

	private PersonService personService;
	public MyController(PersonService personService) {  	//constructor injection 
		super();
		this.personService = personService;
	}
	
	//@Autowired // get the bean called userRepository , you could also use constructor injection , they are equivalent
	//private PersonRepository personRepository;  

	
	@GetMapping(path = "/1")
	public Person getAllUsers() {
		
		//save into database 
		Person n = new Person("messi", "ident");		
		personService.save(n);
		
		//find person by id and return it 
		Person person = personService.findById(1L).get();	
		return person;
	}
	
	
	
}


