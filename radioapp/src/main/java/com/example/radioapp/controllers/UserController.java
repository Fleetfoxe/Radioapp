package com.example.radioapp.controllers;

import com.example.radioapp.entities.User;
import com.example.radioapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }
    /* funkar inte RIKTIGT än
    @GetMapping("/auth/users")
    public List<User> getUsers(){
        System.out.println("funkar de 2?");
        return userService.getUsers();
    }

     */
}
