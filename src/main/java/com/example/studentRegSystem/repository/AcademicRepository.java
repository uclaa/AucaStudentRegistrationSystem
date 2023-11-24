package com.example.studentRegSystem.repository;

import com.example.studentRegSystem.domain.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicRepository extends JpaRepository<AcademicUnit,Integer> {
}
