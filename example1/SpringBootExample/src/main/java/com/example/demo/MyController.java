package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/example")
public class MyController {
	
	//run on browser -> localhost:8080/example/1
	//output is {"brand":"toyota","year":2000}
    @GetMapping("/1")
    public Car getCar() {
    	Car car = new Car("toyota", 2000);
        return car;
    }
    
    
}

