package com.example.radioapp.services;

import com.example.radioapp.repositories.EpisodeRepo;
import com.example.radioapp.repositories.FavoriteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepo favoriteRepo;
}
