package com.example.studentRegSystem.repository;

import com.example.studentRegSystem.domain.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester,Integer> {
}
