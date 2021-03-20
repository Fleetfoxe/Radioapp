package com.example.radioapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long episode;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Favorite() {    }

    public Favorite(long id, User user, long episode) {
        this.id = id;
        this.user = user;
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", user=" + user +
                ", episode=" + episode +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getEpisode() {
        return episode;
    }

    public void setEpisode(long episode) {
        this.episode = episode;
    }
}
