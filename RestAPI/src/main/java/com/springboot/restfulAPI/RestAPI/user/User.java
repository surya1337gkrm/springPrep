package com.springboot.restfulAPI.RestAPI.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name="user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    //we can use @JSONProperty annotation to specify the fieldname in the json response
    @Size(min=2,max=10,message="Username should atleast contain 2 charecters and at-max 10 charecters")
//    @JsonProperty("username")
    private String name;
    @Past(message="Birth date should be in the past.")
    private LocalDate bday;

    //As one user can have many posts -> relation between User & Posts is One to Many
    // In order to map User and Posts, Post class should have a User type variable which can be used to map.
    //here Post class has a variable named "user"

    //We dont want to show these values in the json response. so Ignored using @JsonIgnore
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;


    public User(){

    }
    public User(Integer id, String name, LocalDate bday) {
        this.id = id;
        this.name = name;
        this.bday = bday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bday=" + bday +
                '}';
    }
}
