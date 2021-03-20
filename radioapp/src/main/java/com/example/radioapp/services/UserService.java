package com.example.radioapp.services;

import com.example.radioapp.configs.MyUserDetailService;
import com.example.radioapp.entities.Favorite;
import com.example.radioapp.entities.User;
import com.example.radioapp.repositories.FavoriteRepo;
import com.example.radioapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private MyUserDetailService detailService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FavoriteRepo favoriteRepo;


    public User register(User user){

        return detailService.registerUser(user);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }
    public User whoAmI(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByEmail(email);

    }

    public void createFavorite() {
        Favorite favorite = new Favorite();
        favorite.setEpisode(5);
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        favorite.setUser(userRepo.findByEmail(email));
        favoriteRepo.save(favorite);
    }


    public void createFavorite2(long episodeid) {
        if (!favoriteRepo.existsFavoriteByEpisode(episodeid)) {
            Favorite favorite = new Favorite();
            favorite.setEpisode(episodeid);
            String email = SecurityContextHolder.getContext().getAuthentication().getName();
            favorite.setUser(userRepo.findByEmail(email));
            favoriteRepo.save(favorite);
        }
    }

    public List<Favorite> getAllFavorites() {
        return favoriteRepo.findAll();
    }


}
