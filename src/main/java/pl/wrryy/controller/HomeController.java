package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wrryy.entity.User;
import pl.wrryy.repository.UserRepository;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping({"/","/home"})
    public String home(){
        return "index";
    }

    @Autowired
    UserRepository userRepository;

}
