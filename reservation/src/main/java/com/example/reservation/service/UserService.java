package com.example.reservation.service;

import com.example.reservation.model.User;
import com.example.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User register(User user) {
        // You can add additional checks (e.g., duplicate username or email) here if needed
        return userRepository.save(user);
    }

    // Login an existing user
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;  // Return null if no match or incorrect password
    }
}
