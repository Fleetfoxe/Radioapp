package com.example.radioapp.entities;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Program {

    @Id
    private String description;
    private String programurl;

    public Program(String description, String programurl) {
        this.description = description;
        this.programurl = programurl;

    }

    public Program() {}

    public Program(String description) {
        this.description = description;
    }

    public Program(String description, Long id, String s, String programurl) {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgramurl() {
        return programurl;
    }

    public void setProgramurl(String programurl) {
        this.programurl = programurl;
    }

    @Override
    public String toString() {
        return "Program{" +
                "description='" + description + '\'' +
                ", programurl='" + programurl + '\'' +
                '}';
    }

    /*
    public class ProgramCategory{
    private long id;
    private String name;

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
        */
}





