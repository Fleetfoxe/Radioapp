package com.example.radioapp.controllers;

import com.example.radioapp.entities.Favorite;
import com.example.radioapp.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

}
