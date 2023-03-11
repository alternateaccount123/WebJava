package com.example.accessingdatamysql;

//https://spring.io/guides/gs/accessing-data-mysql/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//EQUIVALENT
//$ curl localhost:8080/demo/add -d name=First -d email=someemail@someemailprovider.com
//POST localhost:8080/demo/add?name=First&email=someemail@someemailprovider.com

//EQUIVALENT
//$ curl 'localhost:8080/demo/all'
//GET localhost:8080/demo/all

@Controller 
@RequestMapping(path = "/demo") // This means URL's start with "localhost:8080/demo" 
public class MainController {
	
	
	@Autowired //this anottation tells spring to get the bean called userRepository
	private UserRepository userRepository;

		
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		// @ResponseBody tells spring that the response body will be "Saved", this will be desplayed in screen 
		// @RequestParam tells spring is a uri parameter

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

		
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	
	
	
}