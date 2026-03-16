package com.klu.skill_7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.skill_7.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer>{

    List<Course> findByTitle(String title);

}