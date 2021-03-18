package com.example.radioapp.entities;

import javax.persistence.*;

@Entity
@Table(name="channels")
public class Channel {

    @Id // primary key
    private long id;

    private String name;

    private String image;
    private String scheduleurl;

    public Channel() {    }

    public Channel(long id, String name, String image, String scheduleurl) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.scheduleurl = scheduleurl;
    }

    @Override
    public String toString() {
        return "\nchannel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", broadcast='" + image + '\'' +
                ", program='" + scheduleurl + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getScheduleurl() {
        return scheduleurl;
    }

    public void setScheduleurl(String scheduleurl) {
        this.scheduleurl = scheduleurl;
    }
}
