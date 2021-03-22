package com.example.radioapp.services;

import com.example.radioapp.configs.MyUserDetailService;
import com.example.radioapp.entities.User;
import com.example.radioapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private MyUserDetailService detailService;
    @Autowired
    private UserRepo userRepo;


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



    public User getById(long id){
        Optional<User> user = userRepo.findById(id);
            if(user.isPresent()){

            return user.get();
            }

        return null;
    }


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
}
