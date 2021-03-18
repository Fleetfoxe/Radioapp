package com.example.radioapp.entities;

import javax.persistence.*;

@Entity
    @Table(name = "programs")
    public class Program {

        @Id
        private long id;
        String name;

        public Program(long id, String name) {
            this.id = id;
            this.name = name;
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

        @Override
        public String toString() {
            return "\nProgram{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
