package com.klu.skill_9.controller;

import com.klu.skill_9.exception.InvalidInputException;
import com.klu.skill_9.exception.StudentNotFoundException;
import com.klu.skill_9.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    private static final Map<Integer, Student> studentDB = new HashMap<>();

    static {
        studentDB.put(1, new Student(1, "Alice", "Computer Science"));
        studentDB.put(2, new Student(2, "Bob", "Mathematics"));
        studentDB.put(3, new Student(3, "Charlie", "Physics"));
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;
        try {
            studentId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(
                "Invalid input: '" + id + "' is not a valid student ID. Please provide a numeric ID."
            );
        }

        Student student = studentDB.get(studentId);
        if (student == null) {
            throw new StudentNotFoundException(
                "Student with ID " + studentId + " was not found in the system."
            );
        }

        return student;
    }
}