package com.example.radioapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "programs")
public class Program {

    @Id
    private String description;
    private String programcategory;
    private String id;
    private String name;


    public Program(String description, String programcategory) {
        this.description = description;
        this.programcategory = programcategory;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgramcategory() {
        return programcategory;
    }

    public void setProgramcategory(String programcategory) {
        this.programcategory = programcategory;
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