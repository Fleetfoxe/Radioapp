package com.example.radioapp.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Episode {

   @Id
   private long id;
   private String title;
   private String starttimeutc;
   private String endtimeutc;
   private String program;
   private String channel;
   private String imageurl;

    public Episode() {
    }

    public Episode(long id, String title, String starttimeutc, String endtimeutc, String program, String channel, String imageurl) {
        this.id = id;
        this.title = title;
        this.starttimeutc = starttimeutc;
        this.endtimeutc = endtimeutc;
        this.program = program;
        this.channel = channel;
        this.imageurl = imageurl;
    }

    public Episode(String title, String starttimeutc, String endtimeutc, String program, String channel, String imageurl) {
        this.title = title;
        this.starttimeutc = starttimeutc;
        this.endtimeutc = endtimeutc;
        this.program = program;
        this.channel = channel;
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", starttimeutc='" + starttimeutc + '\'' +
                ", endtimeutc='" + endtimeutc + '\'' +
                ", program='" + program + '\'' +
                ", channel='" + channel + '\'' +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStarttimeutc() {
        return starttimeutc;
    }

    public void setStarttimeutc(String starttimeutc) {
        this.starttimeutc = starttimeutc;
    }

    public String getEndtimeutc() {
        return endtimeutc;
    }

    public void setEndtimeutc(String endtimeutc) {
        this.endtimeutc = endtimeutc;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
