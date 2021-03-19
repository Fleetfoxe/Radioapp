package com.example.radioapp.services;

import com.example.radioapp.configs.MyUserDetailService;
import com.example.radioapp.entities.Friend;
import com.example.radioapp.entities.User;
import com.example.radioapp.repositories.FriendRepo;
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
    @Autowired
    private FriendRepo friendRepo;

    //ArrayList<Friend> friendsList = new ArrayList<>();


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

   public Friend addFriend(String friendEmail){
        Friend friend1 = new Friend();
        String userEmail =SecurityContextHolder.getContext().getAuthentication().getName();
        friend1.setUser(userEmail);
        friend1.setFriend(friendEmail);

    return friendRepo.save(friend1);
   }


    /*
    public ArrayList<String> friendEmail(String email){
        ArrayList<String> friendList = new ArrayList<>();
        friendList.add(email);
        return friendList;
    }

     */
    public User getById(long id){
        Optional<User> user = userRepo.findById(id);
            if(user.isPresent()){

            return user.get();
            }

        return null;
    }


}
