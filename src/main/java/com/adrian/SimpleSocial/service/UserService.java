package com.adrian.SimpleSocial.service;

import com.adrian.SimpleSocial.entity.User;
import com.adrian.SimpleSocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Implement logic to hash password before saving
        user.setPassword(hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    private String hashPassword(String password)
    {
        // Implement logic to hash password using a secure hashing algorithm
        // (e.g., BCrypt)
      /*  return // Hashed password*/
        return "";
    }

    // Additional methods for login, retrieving user information, etc.
}