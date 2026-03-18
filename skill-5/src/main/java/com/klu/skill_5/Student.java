package com.klu.skill_5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String gender;

    // Field Injection using @Autowired
    @Autowired
    private Certification certification;

    // Default constructor
    public Student() {
        this.id = 1;
        this.name = "Ravi Kumar";
        this.gender = "Male";
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Certification getCertification() { return certification; }
    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + 
               ", name=" + name + 
               ", gender=" + gender + 
               ", certification=" + certification + "]";
    }
}

