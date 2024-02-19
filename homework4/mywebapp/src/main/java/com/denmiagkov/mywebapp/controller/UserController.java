package com.denmiagkov.mywebapp.controller;

import com.denmiagkov.mywebapp.model.User;
import com.denmiagkov.mywebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", service.getUsers());
        return "users";
    }

    @PostMapping("/users")
    public String addUser(User user, Model model) {
        service.addUser(user);
        model.addAttribute("users", service.getUsers());
        return "users";
    }
}
