package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wrryy.entity.Tweet;
import pl.wrryy.entity.User;
import pl.wrryy.repository.CommentRepository;
import pl.wrryy.repository.MessageRepository;
import pl.wrryy.repository.TweetRepository;
import pl.wrryy.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"user"})
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    MessageRepository messageRepository;

    @ModelAttribute("tweet")
    public Tweet nt(HttpSession session) {
        Tweet tweet = new Tweet();
        tweet.setUser(new User());
        return tweet;
    }
    @GetMapping("/{username}")
    public String showUserSettings(Model model, @PathVariable String username, HttpSession session) {
        User user = userRepository.findUserByUsernameEquals(username);
        model.addAttribute("usr", user);
        model.addAttribute("users",  userRepository.findAllByFullName());
        model.addAttribute("tweets", tweetRepository.findTweetsByUserId(user.getId()));
        model.addAttribute("comments", commentRepository.findCommentsByUserId(user.getId()));
        return "user/userpage";
    }
    @GetMapping("/{username}/messages")
    public String messages(Model model, HttpSession session, @PathVariable String username){
        User userLogged = (User) session.getAttribute("user");
        User user = userRepository.findUserByUsernameEquals(username);

        if (userLogged == user) {
            model.addAttribute("messages", messageRepository.findAllByAddressee_UsernameOrderByCreatedDesc(userLogged.getUsername()));
        }else{
            return "redirect:/login";
        }
    return "user/messages";
    }
}
