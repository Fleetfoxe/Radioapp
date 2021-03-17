package com.example.radioapp.controllers;

import com.example.radioapp.entities.User;
import com.example.radioapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }


    @GetMapping("/rest/users")
    public List<User> getUsers(){

        return userService.getAll();
    }

    @GetMapping("/auth/whoami")
    public User whoAmI(){
        return userService.whoAmI();
    }


}
