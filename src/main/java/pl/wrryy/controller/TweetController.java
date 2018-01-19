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
@RequestMapping("/tweet")
public class TweetController {
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    @ModelAttribute("users")
    public List<User> users() {
        return userRepository.findAll();
    }

    @RequestMapping("/all")
    public String allTweets(Model model) {
        model.addAttribute("tweets", tweetRepository.sortByCreated());
        return "tweets";
    }

    @GetMapping("/add")
    public String addTweet(Model model) {
        model.addAttribute("tweet", new Tweet());
        return "tweet/add";
    }

    @PostMapping("/add")
    public String addTweet(@Valid Tweet tweet, BindingResult result) {
        if (result.hasErrors()) {
            return "tweet/add";
        } else {
            tweetRepository.save(tweet);
            return "redirect:/tweet/all";
        }
    }

    @RequestMapping("/deletetweets")
    public String deleteUserTweets(@RequestParam int id) {
        for (Tweet t : tweetRepository.findTweetsByUserId(id)) {
            tweetRepository.delete(t.getId());
        }
        return "redirect:/user/all";
    }
}
