package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wrryy.entity.Comment;
import pl.wrryy.entity.User;
import pl.wrryy.repository.CommentRepository;
import pl.wrryy.repository.TweetRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
 @RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    TweetRepository tweetRepository;

    @PostMapping("/add/{id}")
    public String addComment(@Valid Comment comment, BindingResult result,
                             HttpSession session, @PathVariable int id, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        } else if(result.hasErrors()){
            return "redirect:/tweet/"+id;
        } else {
            comment.setUser(user);
            comment.setTweet(tweetRepository.findOne(id));
            commentRepository.save(comment);
            return "redirect:/tweet/"+id;
        }
    }
}
