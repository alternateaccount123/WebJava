package com.example.demo; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/")
public class MyController {
	
	@Autowired // inject commentService , you could also use constructor injection , they are equivalent
	private CommentService commentService;  
    
    //it will look for the html in either the template or static so dont worry aabout it 
    @GetMapping("/")
    public String loadIndexPage() {
        return "index.html";   	
    }

    
    @PostMapping("/comments")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
    	System.out.println(",,,,,,,,,,,,,,,post handler method executed,,,,,,,,,,,,,,,,,,,,,");
        comment.setMessage(comment.getMessage());
        Comment savedComment = commentService.addComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }
    
  

    
}






