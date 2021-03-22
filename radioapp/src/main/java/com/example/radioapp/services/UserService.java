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

    public List<Favorite> getAllFavorites() {
        return favoriteRepo.findAll();
    }


    public Favorite addFavorite(Favorite favorite) {
        User user = whoAmI();

        //if Logged in
        if (user != null) {
            favorite.setUser(user);
            //If episode id is sent in body
            if(favorite.getEpisodeId() != 0){
                //If the favorite episode doesn't already exist
                if (!favoriteRepo.existsFavoriteByEpisodeId(favorite.getEpisodeId())) {
                    return favoriteRepo.save(favorite);
                }
            }
        }
        return null;
    }
}
