package com.example.studentRegSystem.domain;

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
@Table(name = "academic_unit")
public class AcademicUnit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "unity_type")
    private UnityType unityType;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "parent_id", referencedColumnName = "id",nullable = true)
    private AcademicUnit parentUnit;
    @OneToMany(mappedBy = "unit")
    @JsonManagedReference("academicUnitRegistrationReference")
    private List<StudentRegistration> students;

    @OneToMany(mappedBy = "academic")
    @JsonManagedReference("academicCourseReference")
    private List<Course> courses = new ArrayList<>();


    public AcademicUnit(int id) {
        this.id = id;
    }



    public AcademicUnit(String code, String name, UnityType unityType, AcademicUnit parentUnit) {
        this.code = code;
        this.name = name;
        this.unityType = unityType;
        this.parentUnit = parentUnit;
    }




    @Override
    public String toString() {
        return "AcademicUnit{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", unityType=" + unityType +
                ", parentUnit=" + parentUnit +
                ", students=" + students +
                ", courses=" + courses +
                '}';
    }

    public enum UnityType {
        PROGRAMME,
        FACULTY,
        DEPARTMENT
    }
}
