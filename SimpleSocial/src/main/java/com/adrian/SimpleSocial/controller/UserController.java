package com.adrian.SimpleSocial.controller;

import com.adrian.SimpleSocial.entity.User;
import com.adrian.SimpleSocial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // Base path for user endpoints
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register") // POST request for registration
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);

    }

    // Additional methods for login, profile retrieval, etc.

}