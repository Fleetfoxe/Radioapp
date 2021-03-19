package com.example.radioapp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String user;
    private String friend;



    public Friend(String user, String friend) {
        this.user = user;
        this.friend = friend;
    }

    public Friend() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "\nFriend{" +
                "user=" + user +
                ", friend='" + friend + '\'' +
                '}';
    }
}
