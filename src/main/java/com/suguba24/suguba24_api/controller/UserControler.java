package com.suguba24.suguba24_api.controller;

import com.suguba24.suguba24_api.entity.User;
import com.suguba24.suguba24_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserControler {
    @Autowired private UserService userService;

    // User endpoints
    @PostMapping("/users")
    public User addUser(@RequestBody User user) { return userService.addUser(user); }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) { return userService.updateUser(id, user); }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) { userService.deleteUser(id); }

}
