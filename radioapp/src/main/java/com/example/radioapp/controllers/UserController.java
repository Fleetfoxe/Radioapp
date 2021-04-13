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

    //register user
    @PostMapping("/auth/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    //get all users
    @GetMapping("/rest/users")
    public List<User> getUsers(){

        return userService.getAll();
    }

    //get logged in user
    @GetMapping("/auth/whoami")
    public User whoAmI(){
        return userService.whoAmI();
    }

    //get user by ID
    @GetMapping("/rest/users/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getById(id);
    }
    //get all favorites
    @GetMapping("/rest/favorites")
    public List<Favorite> getAllFavorites() {
        return userService.getAllFavorites();
    }

    //add friend
    @PutMapping("/api/add-friend")
    public User addFriend(@RequestBody User friend){

    return userService.addFriend(friend);
    }

    //remove friend
    @PutMapping("/api/deleteFriend")
    public void removeFriend(@RequestBody User friend){

        userService.deleteFriend(friend);
    }

    //add favorite
    @PostMapping("/rest/favorites/add-favorite")
    public Favorite addFavorite(@RequestBody Favorite favorite) {
        return userService.addFavorite(favorite);
    }

    //get MY favorites (List of favorite objects with Id numbers)
    @GetMapping("/rest/myFavorites")
    public List<Favorite> showMyFavorite() {
       return userService.showMyFavorites();
    }



}
