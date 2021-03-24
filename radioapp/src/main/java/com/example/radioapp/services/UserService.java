package com.example.radioapp.services;

import com.example.radioapp.configs.MyUserDetailService;
import com.example.radioapp.entities.Favorite;
import com.example.radioapp.entities.User;
import com.example.radioapp.repositories.FavoriteRepo;
import com.example.radioapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private MyUserDetailService detailService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FavoriteRepo favoriteRepo;

    //method for registering a user
    public User register(User user){

        return detailService.registerUser(user);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }
    //finds the logged in user
    public User whoAmI(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepo.findByEmail(email);
    }

    //get user by ID
    public User getById(long id){
        Optional<User> user = userRepo.findById(id);
            if(user.isPresent()){

            return user.get();
            }

        return null;
    }
    //method for adding a friend
    public User addFriend(User friend) {
        User user = whoAmI();//get logged in user

        //if logged in
        if(user != null){
            user.addFriend(friend);
            return userRepo.save(user);
        }
        //user is not logged in
        return null;
    }

    //remove friend
    public User deleteFriend(User friend){
        User user = whoAmI();//get logged in user

        //if logged in
        if(user != null){
            user.deleteFriend(friend);
            return userRepo.save(user);
        }
        //user is not logged in
        return null;
    }
    //Method for getting all favorites in the database(regardless of user)
    public List<Favorite> getAllFavorites() {
        return favoriteRepo.findAll();
    }

    //Method for adding a favorite to logged in user
    public Favorite addFavorite(Favorite favorite) {
        User user = whoAmI();
        //if Logged in
        if (user != null) {
            favorite.setUser(user);
                return favoriteRepo.save(favorite);
        }
        return null;
    }
    //Method for getting the favorites list of the user logged in
    public List<Favorite> showMyFavorites(){
        User user = whoAmI();
        List<Favorite> favorites;

        favorites = user.getFavorites();


        return favorites;
    }
}
