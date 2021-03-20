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
    @Autowired
    private UserRepo userRepo;
/*
    public void createFavorite() {
        System.out.println("Running createFavorite");
        Favorite favorite = new Favorite();
        favorite.setEpisode(5);
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        favorite.setUser(userRepo.findByEmail(email));
        favoriteRepo.save(favorite);
    }
*/

/*
    public void createFavorite(long episodeid) {
        System.out.println(episodeid);
        Favorite favorite = new Favorite();
        favorite.setEpisode(episodeid);
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        favorite.setUser(userRepo.findByEmail(email));
        favoriteRepo.save(favorite);
    }*/
}

