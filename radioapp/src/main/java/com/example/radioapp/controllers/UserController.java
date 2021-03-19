package com.example.radioapp.controllers;

import com.example.radioapp.entities.Friend;
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
/*
    @PostMapping("/post/friends")
    public String createFriend(String email){

       // return userService.friend(email);
    }


 */

    @GetMapping("/rest/users")
    public List<User> getUsers(){

        return userService.getAll();
    }

    @GetMapping("/auth/whoami")
    public User whoAmI(){
        return userService.whoAmI();
    }

    @GetMapping("/rest/users/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getById(id);
    }
    @PostMapping("/rest/friends")
    public Friend friendShip(@RequestBody String friend){
        return userService.addFriend(friend);
    }

}
