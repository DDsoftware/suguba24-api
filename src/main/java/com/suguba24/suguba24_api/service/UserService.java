package com.suguba24.suguba24_api.service;

import com.suguba24.suguba24_api.entity.User;
import com.suguba24.suguba24_api.entity.Product;
import com.suguba24.suguba24_api.repository.UserRepository;
import com.suguba24.suguba24_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    @Autowired private UserRepository userRepo;
    @Autowired private ProductRepository productRepo;
    @Autowired private PasswordEncoder passwordEncoder;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public Optional<User> login(String username, String password) {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }

    public User addUser(User user) { return userRepo.save(user); }
    public User updateUser(Long id, User user) {
        user.setId(id);
        return userRepo.save(user);
    }
    public void deleteUser(Long id) { userRepo.deleteById(id); }

    public void addToCart(Long userId, Long productId) {
        User user = userRepo.findById(userId).orElseThrow();
        Product product = productRepo.findById(productId).orElseThrow();
        user.getCart().add(product);
        userRepo.save(user);
    }

    public void removeFromCart(Long userId, Long productId) {
        User user = userRepo.findById(userId).orElseThrow();
        user.getCart().removeIf(p -> p.getId().equals(productId));
        userRepo.save(user);
    }
}