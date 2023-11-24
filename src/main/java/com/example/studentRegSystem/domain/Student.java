package com.example.studentRegSystem.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name="regNo")
    private String regNo;
    @Column(name="fname")
    private String firstName;
    @Column(name="lname")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="birth_date")
    private String dob;
    @Column(name="password")
    private String password;
    @OneToMany(mappedBy="student")
    @JsonManagedReference("registrationStudentReference")
    private List<StudentRegistration> students;



    public Student(String regNo, String firstName, String lastName, String email, String phone, String dob, String password, List<StudentRegistration> students) {
        this.regNo = regNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.password = password;
        this.students = students;
    }







    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", regNo='" + regNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob='" + dob + '\'' +
                ", password='" + password + '\'' +
                ", students=" + students +
                '}';
    }
}
