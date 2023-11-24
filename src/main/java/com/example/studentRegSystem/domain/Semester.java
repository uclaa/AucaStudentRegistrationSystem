package com.example.studentRegSystem.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "semesters")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semid;
    @Column(name="Sem_name")
    private String name;
    @Column(name="Sem_startdate")
    private LocalDate startdate;
    @Column(name="Sem_enddate")
    private LocalDate enddate;
    @OneToMany(mappedBy = "sem")
    @JsonManagedReference("semesterRegistrationReference")
    private List<StudentRegistration> reg;
    @OneToMany(mappedBy = "sems")
    @JsonManagedReference("semesterCourseReference")
    private List<Course> course;



    public Semester(int semid) {
        this.semid = semid;
    }





    @Override
    public String toString() {
        return "Semester{" +
                "semid=" + semid +
                ", name='" + name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", reg=" + reg +
                ", course=" + course +
                '}';
    }
}
