package com.surya.jwt.jwtImplementation.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor //Instead of manually writing the constructors and getter/setters, we can use Lombok @Data annotation
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

    //Users - roles : many-to-many relationship
    //Each user can have multiple roles and each role can have multiple users
    //fetch roles whenever users is fetched.
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="user_roles",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
    private List<RoleEntity> roles=new ArrayList<>();

}

