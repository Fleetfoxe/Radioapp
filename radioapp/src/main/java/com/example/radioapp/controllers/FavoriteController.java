package com.example.radioapp.controllers;

import com.example.radioapp.entities.Favorite;
import com.example.radioapp.services.EpisodeService;
import com.example.radioapp.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/rest/fav")
    public String helloworld() {
        return "Hello World!";
    }


/*
    @GetMapping("/rest/favorites2")
    public void createFavorite() {
        favoriteService.createFavorite();
    }
*/

    /*
    @GetMapping("/rest/favorites/{episodeid}")
    public void createFavorite(@PathVariable long episodeid) {
        favoriteService.createFavorite(episodeid);
    }
*/
}
