package com.springboot.restfulAPI.RestAPI.user;

import com.springboot.restfulAPI.RestAPI.user.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAController {

    //autowiring - using constructor injection
    private UserRepository userRepository;
    private PostRepository postRepository;
    public UserJPAController(UserRepository userRepository,PostRepository postRepository){

        this.userRepository=userRepository;
        this.postRepository=postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User getUser(@PathVariable int id){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("User with id: %s is not found.",id));
        }
        return user.get();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        System.out.println(user);
        User userCreated=userRepository.save(user);
        //here location is a header that will be added to the response. It is optional. We can pass null in the place of location
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable int id){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("User with id: %s not found.",id));
        }
        System.out.println(user.get().getPosts());
        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> addPost(@PathVariable int id,@Valid @RequestBody Post post ){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("User with ID: %s is not found.",id));
        }
        post.setUser(user.get());
        postRepository.save(post);

        return ResponseEntity.created(null).build();
    }

    @PutMapping("/jpa/users/{id}/posts/{postid}")
    public Post updatePost(@PathVariable int id,@PathVariable int postid,@RequestBody Post post){

        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("User with ID: %s is not found.",id));
        }
        post.setUser(user.get());
        post.setId(postid);
        return postRepository.save(post);
    }

    //We can add locally configure cors as follows
//    @CrossOrigin -> Allows from all origins
//            @CrossOrigin(origins = "http://localhostL1234") -> allows from specific origin

    @DeleteMapping("/jpa/users/{id}/posts/{postid}")
    public ResponseEntity<Post> deletePost(@PathVariable int id,@PathVariable int postid){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("User with ID: %s is not found.",id));
        }
        postRepository.deleteById(postid);
        return ResponseEntity.noContent().build();
    }
}
