package com.klu.skill_7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.skill_7.entity.Course;
import com.klu.skill_7.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course c){
        Course course = service.addCourse(c);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<>(service.getCourses(), HttpStatus.OK);
        
    }
    @PutMapping
    public ResponseEntity<?> updateCourse(@RequestBody Course c){
        return new ResponseEntity<>(service.updateCourse(c), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){
        service.deleteCourse(id);
        return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
    }
    
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title){
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }

}