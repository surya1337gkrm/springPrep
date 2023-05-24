package com.surya.course;

import com.surya.course.Course;
import com.surya.course.JPA.CourseJPA.jpa.CourseJPA;
import com.surya.course.JPAData.JPADataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JPACommandlineRunner implements CommandLineRunner {

    // JPA
//    @Autowired
//    private CourseJPA courseJPA;

    @Autowired
    private JPADataRepository jpaData;
    @Override
    public void run(String... args) throws Exception {

        //JPA
//        courseJPA.insert(new Course(1,"Learn Spring!","Udemy"));
//        courseJPA.insert(new Course(2,"Learn SpringBoot!","Udemy"));
//
//        System.out.println(courseJPA.findById(1));
//
//        courseJPA.deleteById(1);
//
//        System.out.println(courseJPA.findById(2));

        // Spring Data JPA
        jpaData.save(new Course(1,"01.Java","Telusko"));
        jpaData.save(new Course(2,"02.Spring","Udemy"));
        jpaData.save(new Course(3,"03.SpringBoot","Udemy"));
        jpaData.save(new Course(4,"01.Java Threads","Youtube"));

        System.out.println(jpaData.findAll());
        System.out.println(jpaData.findById(1l));
        System.out.println(jpaData.findByAuthor("Telusko"));

        jpaData.deleteById(4l);


    }
}
