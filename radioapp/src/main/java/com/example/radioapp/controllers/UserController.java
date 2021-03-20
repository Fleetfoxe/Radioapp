package com.example.radioapp.controllers;

import com.example.radioapp.entities.Favorite;
import com.example.radioapp.entities.User;
import com.example.radioapp.services.FavoriteService;
import com.example.radioapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FavoriteService favoriteService;

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

    @GetMapping("/rest/favorites/test/create")
    public void createFavorite() {
        userService.createFavorite();
    }

    @GetMapping("/rest/favorites/{episodeid}")
    public void createFavorite2(@PathVariable long episodeid) {
        userService.createFavorite2(episodeid);
    }

    @GetMapping("/rest/favorites")
    public List<Favorite> getAllFavorites() {
        return userService.getAllFavorites();
    }
}
