package com.example.SpringFromZero;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

//<2> add service "PersonService"to handle business logic 
//the busineess logic could be inside any of the methods 
//i.e. add anything else you would like for this particular method to do. i.e. exception for deletion only allowed for admin , etc  
@Service
public class PersonService {
	

    private PersonRepository personRepository;
    //constructor 
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //methods
    public Person save(Person project) {
        return personRepository.save(project);
    }

	public List<Person> findByFirstName(String string) {
		return personRepository.findByFirstName(string);
	}
	
	
	

}