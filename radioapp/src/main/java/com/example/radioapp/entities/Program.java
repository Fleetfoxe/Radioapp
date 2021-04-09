package com.example.radioapp.entities;

import javax.persistence.*;

@Entity
public class Program {

    @Id
    private int channelid;
    private String channelname;
    private int programcategory;
    private int id;
    private String name;
    private String description;
    private String programurl;
    private String programimage;

    //Test constructor


    public Program(int channelid, String channelname, int programcategory, int id, String name, String description, String programurl, String programimage) {
        this.channelid = channelid;
        this.channelname = channelname;
        this.programcategory = programcategory;
        this.id = id;
        this.name = name;
        this.description = description;
        this.programurl = programurl;
        this.programimage = programimage;
    }

    public Program() {
    }

    public Program(String description) {
        this.description = description;
    }

    public Program(int id, String name, String description, String programimage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.programimage = programimage;
    }

    public Program(String description, int programcategory) {
        this.description = description;
        this.programcategory = programcategory;
    }

    public Program(int channelid, String name) {
    }

    //public Program(String description, Long aLong, String name, String programurl) { }


    public int getChannelid() {
        return channelid;
    }

    public void setChannelid(int channelid) {
        this.channelid = channelid;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

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





