package com.adrian.SimpleSocial.service;

import com.adrian.SimpleSocial.entity.User;
import com.adrian.SimpleSocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public User registerUser(User user) {
        user.setPassword(hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        // Implement password verification logic here
        User user = userRepository.findByUsername(username);
        if (user != null && verifyPassword(password, user.getPassword())) {
            return user;
        }
        return null;
    }



    private boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private String hashPassword(String password) {
         passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

}