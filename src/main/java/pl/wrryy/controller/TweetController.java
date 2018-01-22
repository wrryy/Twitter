package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wrryy.entity.Tweet;
import pl.wrryy.entity.User;
import pl.wrryy.repository.TweetRepository;
import pl.wrryy.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping("/tweet/")
public class TweetController {
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAllByFullName();
    }
    @RequestMapping("/user/{id}")
    public String userTweets(@PathVariable int id, Model model) {
        model.addAttribute("tweets", tweetRepository.findTweetsByUserIdOrderByCreatedDesc(id));
        return "tweets";
    }
    @PostMapping("/add")
    public String allTweetsAdd(@Valid Tweet tweet, BindingResult result){
        if(tweet.getUser()==null){
            return "redirect:/login";
        }
        else if (result.hasErrors()) {
            return "index";
        } else {
            tweetRepository.save(tweet);
            return "redirect:/";
        }
    }
    @GetMapping("/info")
    

    @RequestMapping("/delete")
    public String deleteTweet(@RequestParam int id){
        tweetRepository.delete(id);
            return "redirect:/tweet/all";
    }
    @PostMapping("/deleteall")
    public String deleteUserTweets(@RequestParam int id) {
        for (Tweet t : tweetRepository.findTweetsByUserId(id)) {
            tweetRepository.delete(t.getId());
        }
        return "redirect:/user/all";
    }
}
