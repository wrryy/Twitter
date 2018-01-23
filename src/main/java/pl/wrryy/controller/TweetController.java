package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wrryy.entity.Comment;
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
@RequestMapping("/tweet/")
public class TweetController {
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;

    //    @ModelAttribute("users")
//    public List<User> getUsers() {
//        return userRepository.findAllByFullName();
//    }
    @ModelAttribute("tweet")
    public Tweet nt(HttpSession session) {
        Tweet tweet = new Tweet();
        tweet.setUser(new User());
        session.setAttribute("tweet", tweet);
        return tweet;
    }

    @PostMapping("/add")
    public String allTweetsAdd(@Valid Tweet tweet, BindingResult result, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        } else if (result.hasErrors()) {
            return "index";
        } else {
            tweet.setUser(user);
            tweetRepository.save(tweet);
            session.removeAttribute("tweet");
            return "redirect:/";
        }
    }

    @GetMapping("/{id}")
    public String tweetEnfo(@PathVariable int id, Model model) {
        Comment comment = new Comment();
        comment.setUser(new User());
        comment.setTweet(new Tweet());
        model.addAttribute("tweets", tweetRepository.findOne(id));
        model.addAttribute("comments", commentRepository.findCommentsByTweetId(id));
        model.addAttribute("comment", comment);

        return "tweet/info";
    }


    @RequestMapping("/delete")
    public String deleteTweet(@RequestParam int id) {
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
