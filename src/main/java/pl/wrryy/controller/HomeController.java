package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.wrryy.entity.Comment;
import pl.wrryy.entity.Tweet;
import pl.wrryy.entity.User;
import pl.wrryy.repository.CommentRepository;
import pl.wrryy.repository.TweetRepository;
import pl.wrryy.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes({"user", "tweet"})
public class HomeController {

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAllByFullName();
    }

    @ModelAttribute("tweet")
    public Tweet nt(HttpSession session) {
        Tweet tweet = new Tweet();
        tweet.setUser(new User());
        session.setAttribute("tweet", tweet);
        return tweet;
    }

    @GetMapping("/")
    public String allTweets(Model model) {
        model.addAttribute("tweets", tweetRepository.sortByCreated());
        return "index";
    }

    @GetMapping("/search/tag")
    public String search(Model model, @RequestParam String tag) {
        String search = "#" + tag;
        model.addAttribute("tweets", tweetRepository.findTweetsByTweetTextContainsOrderByCreatedDesc(search));
        return "tweets";
    }


}
