package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wrryy.entity.User;
import pl.wrryy.repository.TweetRepository;
import pl.wrryy.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/search-tweets")
    public String search(Model model, @RequestParam String start) {
        model.addAttribute("tweets", tweetRepository.findTweetsByTweetTextIsStartingWithOrderByCreatedDesc(start));
        return "tweets";
    }

    @RequestMapping("/{id}/tweets")
    public String userTweets(@PathVariable int id, Model model) {
        model.addAttribute("tweets", tweetRepository.findTweetsByUserIdOrderByCreatedDesc(id));
        return "tweets";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/add";
        } else {
            userRepository.save(user);
            return "redirect:/user/all";
        }
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
    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id){
        userRepository.delete(id);
        return "redirect:/user/all";
    }

    @GetMapping("/clear")
    public String deleteUsers(){
        userRepository.deleteAll();
        return "redirect:/user/all";
    }
    @RequestMapping("/all")
    public String allUsers(Model model){
        model.addAttribute("users", userRepository.findAllByFullName());
        return "user/all";
    }
}
