package com.springboot.restfulAPI.RestAPI.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    //autowiring - using constructor injection
    private UserDaoService userService;
    public UserController(UserDaoService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user=userService.findUserById(id);
        if(user==null){
            throw new UserNotFoundException(String.format("User with id: %s not found.",id));
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
//        System.out.println(user);
        User userCreated=userService.addUser(user);
        //here location is a header that will be added to the response. It is optional. We can pass null in the place of location
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUserById(id);
    }
}
