package com.webapp.FitGuysWeb.service;

import com.webapp.FitGuysWeb.model.USerPrincipal;
import com.webapp.FitGuysWeb.model.User;
import com.webapp.FitGuysWeb.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUSerDetailsService implements UserDetailsService{
    @Autowired
    private userRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }return new USerPrincipal(user);
    }
}