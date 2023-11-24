package com.example.studentRegSystem.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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
@Table(name = "course_definition")
public class CourseDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private String descriptions;
    @OneToOne(mappedBy = "coursd")
    @JsonManagedReference("courseDefinitionReference")
    private Course cours;





    public CourseDefinition(String code, String name, String descriptions) {
        this.code = code;
        this.name = name;
        this.descriptions = descriptions;
    }


    @Override
    public String toString() {
        return "CourseDefinition{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", cours=" + cours +
                '}';
    }
}
