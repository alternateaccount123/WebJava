package com.example.demo;



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
	//private PersonService personService;  

    //output no dto --> {"id":1,"firstname":"john", "lastname":"doe"}
    //output dto --> {"id":1,"firstName":"jon"}
	@GetMapping(path = "/1")
	public PersonDto getAllUsers() {
		
		//save into database 
		Person n = new Person("messi", "713");		
		personService.save(n);
		
		//find person by id and return it 
		Person person = personService.findById(1L).get();	
		return convertToDto(person);
	}
	
	//dto
    private PersonDto convertToDto(Person entity) {  //<2>
    	//you want the to transfer only the data you need, a smaller amount of data.
    	//you want to limit the amount of data that is exposed in the transfer.
    	//below is just a copy of the entity, a subset of the data from an entity
    	PersonDto dto = new PersonDto(entity.getId(), entity.getFirstName());  //omitting field last name 
        return dto;
    }
	
	
	/*
	  //extra methods 
	  
	@PostMapping
    public void create(@RequestBody PersonDto newPerson) {
        this.personService.save(convertToEntity(newPerson));
    }


    private Person convertToEntity(PersonDto dto) {
        Person person = new Person(dto.getFirstName(), null);
        if (!StringUtils.isEmpty(dto.getId())) {
            project.setId(dto.getId());
        }
        return person;
    }
	
	*/
	
}


