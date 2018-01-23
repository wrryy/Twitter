package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wrryy.entity.Message;
import pl.wrryy.entity.User;
import pl.wrryy.repository.MessageRepository;
import pl.wrryy.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;
    @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAllByFullName();
    }
    @PostMapping("/send")
    public String send(@ModelAttribute Message message, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        } else {
            message.setSender(user);
            messageRepository.save(message);
            return "redirect:/tweet/" + id;
        }
    }
}
