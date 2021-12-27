package com.example.student_minitest.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double score;
    private int age;

    @ManyToOne
    @JoinColumn(name = "classRoomId")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(String name, double score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public Student(String name, double score, int age, ClassRoom classRoom) {
        this.name = name;
        this.score = score;
        this.age = age;
        this.classRoom = classRoom;
    }

    public Student(Long id, String name, double score, int age, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
        this.classRoom = classRoom;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
