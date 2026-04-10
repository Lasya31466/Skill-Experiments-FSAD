package com.klu.skill_12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.skill_12.entity.Student;
import com.klu.skill_12.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // ADD
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    // GET ALL
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {
        Student existing = repo.findById(id).orElseThrow();

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());

        return repo.save(existing);
    }

    // DELETE
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}