package com.example.radioapp.services;

import com.example.radioapp.configs.MyUserDetailService;
import com.example.radioapp.entities.User;
import com.example.radioapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private MyUserDetailService detailService;
    @Autowired
    private UserRepo userRepo;


    public User register(User user){

        return detailService.registerUser(user);
    }
/*  funkar inte RIKTIGT än
    public List<User> getUsers() {
        System.out.println("funkar de?");
        return userRepo.findAll();
    }

 */
}
