package com.example.radioapp.entities;

import javax.persistence.*;

@Entity
public class Program {

    @Id
    private String description;
    private String programurl;
    private String programimage;
    private int programcategory;
    private int id;
    private String name;



    public Program(String description, String programurl, String programimage, int programcategory, int id, String name) {
        this.description = description;
        this.programurl = programurl;
        this.programimage = programimage;
        this.programcategory = programcategory;
        this.id = id;
        this.name = name;

    }

    public Program() {
    }

    public Program(String description) {
        this.description = description;
    }

    public Program(String description, int programcategory) {
        this.description = description;
        this.programcategory = programcategory;
    }

    //public Program(String description, Long aLong, String name, String programurl) { }


    public String getProgramimage() {
        return programimage;
    }

    public void setProgramimage(String programimage) {
        this.programimage = programimage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgramcategory() {
        return programcategory;
    }

    public void setProgramcategory(int programcategory) {
        this.programcategory = programcategory;
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


    public class ProgramCategory {
        private long id;
        private String name;

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

    }
}





