package com.example.springJDBC.demo.course.jdbc;

import com.example.springJDBC.demo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCClass {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY =
            """
                insert into course(id,name,author)
                values(?,?,?); 
            """;
    private static String DELETE_QUERY =
            """
                delete from course
                where id= ?;
            """;

    private static String FIND_QUERY=
            """
                select * from course
                where id = ?;
            """;
    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(long id){
        jdbcTemplate.update(DELETE_QUERY,id);
    }


    public void findById(long id){
        //use query
        //or if we know we get only one object ex: while querying using ID
        // In order to use RowMapper there should be a default constructor defined
        System.out.println(jdbcTemplate.queryForObject(FIND_QUERY,new BeanPropertyRowMapper<>(Course.class),id));
    }


}
