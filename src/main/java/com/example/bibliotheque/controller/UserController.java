package com.example.bibliotheque.controller;

import com.example.bibliotheque.model.User;
import com.example.bibliotheque.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

 
    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
   
    