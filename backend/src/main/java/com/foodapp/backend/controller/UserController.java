package com.foodapp.backend.controller;

import com.foodapp.backend.model.User;
import com.foodapp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/login")
    public User login(@RequestParam String email) {
        return userService.getByEmail(email);
    }
}