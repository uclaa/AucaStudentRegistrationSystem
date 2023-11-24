package com.example.studentRegSystem.repository;

import com.example.studentRegSystem.domain.CourseDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDefinitionRepo extends JpaRepository<CourseDefinition,Integer> {
}
