package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@Controller // This means that this class is a Controller
@RequestMapping(path = "/example") //URL's start with /example (after Application path)
public class MyController {
	
	
    @Autowired // get the bean called userRepository , you could also use constructor injection , they are equivalent
    private PersonRepository personRepository;  

	
    @GetMapping
    public String getProjects(Model model) {
    	
    	
    	//sending an person object to html 
    	Person person = new Person ("john","doebasic");
        model.addAttribute("myvariable", person);
        return "mainpage";
    	
    	/*
    	//sending an String object to html 
        model.addAttribute("myvariable", "hello world");
        return "mainpage";
        */
    }
	
	
	
}


