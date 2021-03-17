package com.example.radioapp.entities;

import javax.persistence.*;

@Entity
@Table(name="channels")
public class Channel {


    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // enables auto increment
    private long id;

    private String name;

    private String broadcast;
    private String program;

    public Channel() {    }

    @Override
    public String toString() {
        return "\nchannel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", program='" + program + '\'' +
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

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
