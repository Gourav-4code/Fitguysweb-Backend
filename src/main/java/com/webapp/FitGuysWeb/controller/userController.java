package com.webapp.FitGuysWeb.controller;

import com.webapp.FitGuysWeb.model.user;
import com.webapp.FitGuysWeb.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin
@RequestMapping("/")
public class userController {
    @Autowired
    private userService Service;
    @GetMapping("/home")
    public String hello() {
        return "Hello!!!";
    }
    @PostMapping("/signup")
    user newUser(@RequestBody user newUser) {

        return Service.saveUser(newUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody user user) {
        return Service.verify(user);
    }



}
