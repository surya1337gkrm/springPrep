package com.springboot.restfulAPI.RestAPI.user.jpa;

import com.springboot.restfulAPI.RestAPI.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
