package com.example.radioapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String name;
    private String password;
    @ManyToMany
    @JoinTable(
            name = "friends",//we need cross table
            joinColumns = @JoinColumn(name = "user"),//the user column
            inverseJoinColumns = @JoinColumn(name = "friend") // the friend column(inverse is always the "second" column)

    )
    @JsonIgnoreProperties("")//ignore a property from the related entity
    private List<User> friends;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Favorite> favorites;

    public void addFriend(User user) {

        friends.add(user);

        }
        public List<Favorite> getFavorites () {
            return favorites;
        }

        public void setFavorites (List < Favorite > favorites) {
            this.favorites = favorites;

        }
        public String getName () {
            return name;

        }
        public void deleteFriend (User friend){
            friends.removeIf(userFriend -> userFriend.getId() == friend.getId());//fungerar inte med vanlig loop måste fuska
            //ingen vet varför

        /*for(User userFriend :friends){ samma sak som ovan men fungerar inte
            if(userFriend.getId() ==friend.getId()){

                friends.remove(userFriend);
            }

        }

         */

    }
    public User() {
        }

    public User(String email, String name, String password) {
            this.email = email;
            this.name = name;
            this.password = password;
        }

        public List<User> getFriends () {
            return friends;
        }

        public void setFriends (List < User > friends) {
            this.friends = friends;
        }


    public User( long id, String email){
            this.id = id;
            this.email = email;
        }

        public void setName (String name){
            this.name = name;
        }


        public long getId () {
            return id;
        }

        public void setId ( long id){
            this.id = id;
        }


        public String getEmail () {
            return email;
        }

        public void setEmail (String email){
            this.email = email;
        }

        @JsonIgnore
        public String getPassword () {
            return password;
        }
        @JsonProperty
        public void setPassword (String password){
            this.password = password;
        }

        @Override
        public String toString () {
            return "\nUser{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
}
