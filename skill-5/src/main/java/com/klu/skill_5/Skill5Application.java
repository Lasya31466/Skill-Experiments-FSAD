package com.klu.skill_5;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Skill5Application {

    public static void main(String[] args) {

        ApplicationContext context = 
            SpringApplication.run(Skill5Application.class, args);

        Student student = context.getBean(Student.class);

        System.out.println("===== Student Details =====");
        System.out.println(student);

        System.out.println("\n===== Certification Details =====");
        System.out.println(student.getCertification());
    }
}


