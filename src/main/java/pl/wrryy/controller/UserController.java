package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wrryy.entity.Tweet;
import pl.wrryy.entity.User;
import pl.wrryy.repository.CommentRepository;
import pl.wrryy.repository.TweetRepository;
import pl.wrryy.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"user", "tweet"})
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TweetRepository tweetRepository;
@Autowired
    CommentRepository commentRepository;

    @ModelAttribute("tweet")
    public Tweet nt(HttpSession session) {
        Tweet tweet = new Tweet();
        tweet.setUser(new User());
        session.setAttribute("tweet", tweet);
        return tweet;
    }
    @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAllByFullName();
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam int id) {
        model.addAttribute("user", userRepository.findOne(id));
        return "user/edit";
    }

    @PostMapping("/edit")
    public String editUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit";
        } else {
            userRepository.save(user);
            return "redirect:/user/all";
        }
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        userRepository.delete(id);
        return "redirect:/user/all";
    }

    @RequestMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAllByFullName());
        return "user/all";
    }

    @GetMapping("/{username}")
    public String showUserSettings(Model model, @PathVariable String username) {
//        @SessionAttribute(required = false) User user
        User user =  userRepository.findUserByUsernameEquals(username);
        model.addAttribute("usr", user);
        model.addAttribute("tweets", tweetRepository.findTweetsByUserId(user.getId()));
        model.addAttribute("comments", commentRepository.findCommentsByUserId(user.getId()));
        return "user/userpage";
    }
}
