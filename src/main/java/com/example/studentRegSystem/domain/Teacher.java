package com.example.studentRegSystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codes;
    private String names;
    @Enumerated(EnumType.STRING)
    private Qualification qualification;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "courseid")
    @JsonBackReference("teacherCourseReference")
    private Course courses;


    public Teacher(int id) {
        this.id = id;
    }

    public Teacher(String codes, String names, Qualification qualification, Role role, Course courses) {
        this.codes = codes;
        this.names = names;
        this.qualification = qualification;
        this.role = role;
        this.courses = courses;
    }




    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", codes='" + codes + '\'' +
                ", names='" + names + '\'' +
                ", qualification=" + qualification +
                ", role=" + role +
                ", courses=" + courses +
                '}';
    }

    public enum Qualification {
        Masters,
        PHD,
        PROFESSOR
    }
    public enum Role{
        Lecturer,
        Assistant
    }

}
