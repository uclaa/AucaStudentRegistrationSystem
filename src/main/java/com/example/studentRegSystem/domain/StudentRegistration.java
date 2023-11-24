package com.example.studentRegSystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "student_registration")
@JsonIgnoreProperties({"student", "sem", "unit", "courses"})
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regid;
    @Column(name="registration_date")
    private LocalDate regDate;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @JsonBackReference("registrationStudentReference")
    private Student student;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="semid")
    @JsonBackReference("semesterRegistrationReference")
    private Semester sem;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="acaid")
    @JsonBackReference("academicUnitRegistrationReference")
    private AcademicUnit unit;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_course",joinColumns = @JoinColumn(name="id")
            ,inverseJoinColumns =@JoinColumn(name="courseid"))


    private List<Course> courses=new ArrayList<>();



    public StudentRegistration(int regid) {
        this.regid = regid;
    }


    public StudentRegistration(LocalDate regDate, Student student, Semester sem, AcademicUnit unit, List<Course> courses) {
        this.regDate = regDate;
        this.student = student;
        this.sem = sem;
        this.unit = unit;
        this.courses = courses;
    }




    @Override
    public String toString() {
        return "StudentRegistration{" +
                "regid=" + regid +
                ", regDate=" + regDate +
                ", student=" + student +
                ", sem=" + sem +
                ", unit=" + unit +
                ", courses=" + courses +
                '}';
    }
}
