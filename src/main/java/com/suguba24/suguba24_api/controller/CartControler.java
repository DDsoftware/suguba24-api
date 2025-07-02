package com.suguba24.suguba24_api.controller;

import com.suguba24.suguba24_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartControler {
    @Autowired private UserService userService;

    // Cart endpoints
    @PostMapping("/users/{userId}/cart/{productId}")
    public void addToCart(@PathVariable Long userId, @PathVariable Long productId) {
        userService.addToCart(userId, productId);
    }

    @DeleteMapping("/users/{userId}/cart/{productId}")
    public void removeFromCart(@PathVariable Long userId, @PathVariable Long productId) {
        userService.removeFromCart(userId, productId);
    }
}
