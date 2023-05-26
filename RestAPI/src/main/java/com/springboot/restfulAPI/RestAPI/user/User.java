package com.springboot.restfulAPI.RestAPI.user;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {
    @Id
    private Integer id;
    @Size(min=2,max=10,message="Username should atleast contain 2 charecters and at-max 10 charecters")
    private String name;
    @Past(message="Birth date should be in the past.")
    private LocalDate bday;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bday=" + bday +
                '}';
    }
}
