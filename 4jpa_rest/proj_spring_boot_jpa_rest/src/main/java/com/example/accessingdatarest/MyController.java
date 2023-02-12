package com.example.accessingdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController //this class is a RestController, which means all its handler methods will return a response body by default (displayed in json format)
@RequestMapping(path = "/example") //URL's start with /example (after Application path)
public class MyController {
	
	
	@Autowired // get the bean called userRepository , you could also use constructor injection , they are equivalent
	private PersonRepository personRepository;  

	
	@GetMapping(path = "/1")
	public Person getAllUsers() {
		
		//save into database 
		Person n = new Person("jon", "asdf");		
		personRepository.save(n);
		
		//find person by id and return it 
		Person person = personRepository.findById(1L).get();	
		return person;
	}
	
	
	
}


