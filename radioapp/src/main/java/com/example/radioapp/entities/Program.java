package com.example.radioapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "programs")
public class Program {

    @Id
    private String description;
    private String programCategory;
    private String id;
    private String name;


    public Program() {
    }


    public Program(String description, String programCategory, String id, String name) {
        this.description = description;
        this.programCategory = programCategory;
        this.id = id;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgramCategory() {
        return programCategory;
    }

    public void setProgramCategory(String programCategory) {
        this.programCategory = programCategory;
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