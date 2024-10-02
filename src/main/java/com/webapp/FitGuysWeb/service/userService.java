package com.webapp.FitGuysWeb.service;


import com.webapp.FitGuysWeb.model.User;
import com.webapp.FitGuysWeb.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    private userRepository userRepo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);

    public List<User> getUser() {

        return userRepo.findAll();
    }

    public User saveUser(User newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        return userRepo.save(newUser);
    }

    public String verify(User user) {
        Authentication authentication= authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername(),user.getPassword());
        }
        return "Login Failed";
    }

    public User updateUser(long id, User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);


    }
}
