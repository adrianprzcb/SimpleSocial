package com.adrian.SimpleSocial.controller;

import com.adrian.SimpleSocial.entity.User;
import com.adrian.SimpleSocial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/api") // Base path for user endpoints
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
            // Return the registered user on success
        } catch (Exception e) {
            // Handle exception (e.g., username already exists)
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String>
    login(@RequestBody User request) {
        User user = userService.loginUser(request.getUsername(),
                request.getPassword());
        if (user != null) {
            // Generate authentication token or session ID
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }


}