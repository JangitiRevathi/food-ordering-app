package com.foodapp.backend.controller;
import com.foodapp.backend.util.JwtUtil;
import com.foodapp.backend.model.User;
import com.foodapp.backend.repository.UserRepository;
import com.foodapp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.foodapp.backend.util.JwtUtil;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

   /* @GetMapping("/login")
    public User login(@RequestParam String email) {
        return userService.getByEmail(email);
    }*/
   @PostMapping("/login")
   public String login(@RequestBody User user) {

       User dbUser = userService.getByEmail(user.getEmail());

       if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
           return jwtUtil.generateToken(user.getEmail());
       }

       return "Invalid credentials";
   }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}