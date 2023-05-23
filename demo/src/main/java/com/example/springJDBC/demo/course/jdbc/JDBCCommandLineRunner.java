package com.example.springJDBC.demo.course.jdbc;

import com.example.springJDBC.demo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JDBCCommandLineRunner implements CommandLineRunner {

    @Autowired
    private JDBCClass jdbcClass;

    @Override
    public void run(String... args) throws Exception {
        jdbcClass.insert(new Course(1,"Learn SpringBoot","Udemy"));
        jdbcClass.insert(new Course(2,"Learn SpringBoot APIs","Udemy"));
        jdbcClass.insert(new Course(3,"Learn Unit Testing Spring","Udemy"));

        jdbcClass.deleteById(1);

        jdbcClass.findById(2);
    }
}
