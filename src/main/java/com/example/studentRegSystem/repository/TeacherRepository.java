package com.example.studentRegSystem.repository;

import com.example.studentRegSystem.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
