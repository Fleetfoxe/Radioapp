package com.example.radioapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="favorites")
public class Favorite {
    @Id
    private long episodeId;
    private long programId;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Favorite() {    }

    public Favorite(User user, long episodeId) {
        this.user = user;
        this.episodeId = episodeId;
    }

    public Favorite(long episodeId, long programId, User user) {

        this.episodeId = episodeId;
        this.programId = programId;
        this.user = user;
    }


    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(long episodeId) {
        this.episodeId = episodeId;
    }
    @Override
    public String toString() {
        return "Favorite{" +
                ", episodeId=" + episodeId +
                ", programId=" + programId +
                ", user=" + user +
                '}';
    }
}
