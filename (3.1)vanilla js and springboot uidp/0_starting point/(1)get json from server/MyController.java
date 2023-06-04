package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    @GetMapping("/message")
    public Car getMessage() {
    	Car car = new Car("toyota",2001);
        return car;
    }
}






