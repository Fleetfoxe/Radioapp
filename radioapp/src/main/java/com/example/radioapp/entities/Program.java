package com.example.radioapp.entities;

import javax.persistence.*;

@Entity
    @Table(name = "programs")
    public class Program {

    @Id
    private String id;
    String name;
    String description;


    public Program() {
    }

    public Program(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nProgram{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}