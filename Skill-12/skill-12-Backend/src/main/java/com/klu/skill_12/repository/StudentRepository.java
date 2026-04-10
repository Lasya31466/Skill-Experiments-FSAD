package com.klu.skill_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.skill_12.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}