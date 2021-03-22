package com.example.radioapp.services;

import com.example.radioapp.entities.Favorite;
import com.example.radioapp.repositories.EpisodeRepo;
import com.example.radioapp.repositories.FavoriteRepo;
import com.example.radioapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepo favoriteRepo;

}

