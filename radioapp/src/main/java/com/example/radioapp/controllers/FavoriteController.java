package com.example.radioapp.controllers;

import com.example.radioapp.services.EpisodeService;
import com.example.radioapp.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;

public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

}
