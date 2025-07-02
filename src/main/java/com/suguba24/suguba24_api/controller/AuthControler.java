package com.suguba24.suguba24_api.controller;

import com.suguba24.suguba24_api.entity.User;
import com.suguba24.suguba24_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthControler {
    @Autowired private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // Login (returns JWT token in real implementation)
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> u = userService.login(user.getUsername(), user.getPassword());
        return u.isPresent() ? "JWT_TOKEN" : "Invalid credentials";
    }
}


