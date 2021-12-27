package com.example.student_minitest.model;

import javax.persistence.*;

@Entity
@Table(name = "classRoom")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public ClassRoom() {
    }

    public ClassRoom(String name) {
        this.name = name;
    }

    public ClassRoom(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
