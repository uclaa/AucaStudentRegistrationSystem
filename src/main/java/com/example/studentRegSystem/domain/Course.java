package com.example.studentRegSystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonBackReference(value = "courseDefinitionReference")
    private CourseDefinition coursd;
    @OneToMany(mappedBy = "courses")
    @JsonManagedReference(value = "teacherCourseReference")
    private List<Teacher> teacher;
    @ManyToOne
    @JoinColumn(name="semid")
    @JsonBackReference(value = "semesterCourseReference")
    private Semester sems;
    @ManyToOne
    @JoinColumn(name="acaid")
    @JsonBackReference(value = "academicCourseReference")
    private AcademicUnit academic;
    @ManyToMany(mappedBy = "courses")
    private List<StudentRegistration> students=new ArrayList<>();



    public Course(int courseid) {
        this.courseid = courseid;
    }



    public Course(CourseDefinition coursd, List<Teacher> teacher, Semester sems, AcademicUnit academic, List<StudentRegistration> students) {
        this.coursd = coursd;
        this.teacher = teacher;
        this.sems = sems;
        this.academic = academic;
        this.students = students;
    }



    public Course(CourseDefinition coursd, Semester sems, AcademicUnit academic) {
        this.coursd = coursd;
        this.sems = sems;
        this.academic = academic;
    }



    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", coursd=" + coursd +
                ", teacher=" + teacher +
                ", sems=" + sems +
                ", academic=" + academic +
                ", students=" + students +
                '}';
    }
}
