package com.surya.course.JPAData;

import com.surya.course.Course;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface JPADataRepository extends JpaRepository<Course,Long> {
    List<Course> findByAuthor(String author);
}
