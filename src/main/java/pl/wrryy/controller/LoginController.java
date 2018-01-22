package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.wrryy.entity.User;
import pl.wrryy.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/login")
    public String showLoginForm() {
        return "user/login";
    }

    @PostMapping(path = "/login")
    public String processLoginRequest(@RequestParam("username") String username,
                                      @RequestParam("password") String password, Model model, HttpSession session) {

        User user = userRepository.findOneByUsernameAndPassword(username, password);

        if (user != null) {
            session.setAttribute("user", user);
//            model.addAttribute("username", username);
            return "redirect:/user/userpage";
        } else {
            return "user/login";
        }
    }

    @GetMapping(path = "/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping(path = "/register")
    public String processRegistrationRequest(@Valid User user, BindingResult bresult) {

        if (bresult.hasErrors()) {
            return "user/register";

        } else {
            userRepository.save(user);
            return "redirect:/user/userpage";
        }
    }
}
