package com.example.registration.controllers;

import com.example.registration.entities.User;
import com.example.registration.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String viewHomepage(){
        //Returns the HTML index page
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        //Returns the HTML signup form in templates
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        userRepository.save(user);

        return "register_success";
    }
}
