package com.example.radioapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favorites")
public class Favorite {

    @Id
    private long id;
    private long user;
    private long episode;

    public Favorite() {    }

    public Favorite(long id, long user, long episode) {
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

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getEpisode() {
        return episode;
    }

    public void setEpisode(long episode) {
        this.episode = episode;
    }
}
