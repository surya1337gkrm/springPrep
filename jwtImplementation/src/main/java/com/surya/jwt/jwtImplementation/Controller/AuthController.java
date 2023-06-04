package com.surya.jwt.jwtImplementation.Controller;

import com.surya.jwt.jwtImplementation.DTO.LoginDTO;
import com.surya.jwt.jwtImplementation.DTO.RegisterDTO;
import com.surya.jwt.jwtImplementation.Repository.RoleRepository;
import com.surya.jwt.jwtImplementation.Repository.UserRepository;
import com.surya.jwt.jwtImplementation.models.RoleEntity;
import com.surya.jwt.jwtImplementation.models.UserEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sample")
    public String testFn(){
        return "Hello World!";
    }


    @PostMapping("/auth/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDTO registerDto){
        if(userRepository.existsByUsername(registerDto.getUsername())){
//            return ResponseEntity.badRequest().build();
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        //asssign a role -> by default, anyone whose registered will be assigned user role
        //Note: if we don't have a role in the database, then we will get an error. So, add roles to the db.
        RoleEntity role = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(role));

        //save to db
        userRepository.save(user);
        return new ResponseEntity<>("User Registered.",HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDto){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                loginDto.getPassword()));
        //store the authentication details in the security context so that user don't have to login repeatedly.
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("User Loggedin.",HttpStatus.OK);
    }

}
