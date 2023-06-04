package com.surya.jwt.jwtImplementation.security;

import com.surya.jwt.jwtImplementation.Repository.UserRepository;
import com.surya.jwt.jwtImplementation.models.RoleEntity;
import com.surya.jwt.jwtImplementation.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


//when we defined a custom USerDetailsService other instances of UserDetails should be removed.
//or this will cause the application to crash
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired //not mandatory
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user =userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found."));
        return new User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    //roles aren't directly generated. We need to map through thr roles and assign to the user
    //we need to grant authorities to the user.

    public Collection<GrantedAuthority> mapRolesToAuthorities(List<RoleEntity> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
