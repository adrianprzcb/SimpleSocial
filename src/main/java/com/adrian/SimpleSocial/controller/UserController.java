package com.adrian.SimpleSocial.controller;

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