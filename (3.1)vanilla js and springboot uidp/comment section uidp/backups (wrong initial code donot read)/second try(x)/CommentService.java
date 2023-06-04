package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
    @Autowired
    private CommentRepository commentRepository;
    
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    /*
    public Comment addComment(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }
    */
}
