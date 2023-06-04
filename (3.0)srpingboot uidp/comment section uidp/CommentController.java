package com.example.demo;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
	
    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String mainPage(Model model) {
        List<Comment> comments = commentService.getAllComments();
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new Comment());
        return "mainpage";
    }

    @PostMapping("/addComment")
    public String addComment(@ModelAttribute("newComment") Comment comment) {
        commentService.saveComment(comment);
        return "redirect:/";
    }
}

