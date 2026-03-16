package com.klu.skill_7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.skill_7.entity.Course;
import com.klu.skill_7.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository repo;

    public Course addCourse(Course c){
        return repo.save(c);
    }

    public List<Course> getCourses(){
        return repo.findAll();
    }

    public Course updateCourse(Course c){
        return repo.save(c);
    }

    public void deleteCourse(int id){
        repo.deleteById(id);
    }

    public List<Course> searchByTitle(String title){
        return repo.findByTitle(title);
    }
}