package com.webapp.FitGuysWeb.controller;

import com.webapp.FitGuysWeb.model.User;
import com.webapp.FitGuysWeb.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    User newUser(@RequestBody User newUser) {

        return Service.saveUser(newUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return Service.verify(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id, @RequestBody User user) {
        try {
            User updatedUser = Service.updateUser(id, user);
            if (updatedUser != null) {
                return new ResponseEntity<>("Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/user")
    public List<User> getAllUsers() {
        return Service.getUser();
    }



}
