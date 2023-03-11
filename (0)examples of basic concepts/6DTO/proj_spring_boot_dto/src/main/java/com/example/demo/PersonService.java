package com.example.demo;

import java.util.Optional;
import org.springframework.stereotype.Service;

//the purpose of the service is to handle business logic 
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
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }


    public Person save(Person project) {
        return personRepository.save(project);
    }
	
	
	

}
