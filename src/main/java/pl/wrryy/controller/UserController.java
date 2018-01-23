package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wrryy.entity.User;
import pl.wrryy.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

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

    @GetMapping("/userpage")
    public String showUserSettings(Model model, @SessionAttribute(required = false) User user) {
        if(user!=null){
        model.addAttribute(user);
        return "user/userpage";
        }else{
            return "user/login";
        }
    }
}
