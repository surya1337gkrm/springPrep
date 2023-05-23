package com.surya.course.JPA.CourseJPA.jpa;

import com.surya.course.JPA.CourseJPA.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJPA {
//    @Autowired
    @PersistenceContext
    private EntityManager entity;

    public void insert(Course course){
         entity.merge(course);
    }

    public Course findById(long id){
        return entity.find(Course.class,id);
    }

    public void deleteById(long id){
        Course course=entity.find(Course.class,id);
        entity.remove(course);
    }
}
