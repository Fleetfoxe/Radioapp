package com.example.radioapp.repositories;

import com.example.radioapp.entities.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FriendRepo extends JpaRepository<Friend,Long> {
    Friend addMyFriend(Friend friend);
}
