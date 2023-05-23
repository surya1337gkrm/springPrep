package com.surya.course.JPA.CourseJPA.jpa;

import com.surya.course.JPA.CourseJPA.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JPACommandlineRunner implements CommandLineRunner {

    @Autowired
    private CourseJPA courseJPA;
    @Override
    public void run(String... args) throws Exception {
        courseJPA.insert(new Course(1,"Learn Spring!","Udemy"));
        courseJPA.insert(new Course(2,"Learn SpringBoot!","Udemy"));

        System.out.println(courseJPA.findById(1));

        courseJPA.deleteById(1);

        System.out.println(courseJPA.findById(2));
    }
}
