package com.springboot.restfulAPI.RestAPI.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Data Access Object - DAO
@Component
public class UserDaoService {
    //Static userlist > later will be changed to db.

    private static Integer userCount=0;
    private static List<User> users=new ArrayList();
    static{
        users.add(new User(++userCount,"Surya",LocalDate.now().minusYears(26)));
        users.add(new User(++userCount,"Maddy",LocalDate.now().minusYears(27)));
        users.add(new User(++userCount,"Anirudh",LocalDate.now().minusYears(30)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findUserById(int id){
        //if id and getId() is int instead of Integer, we can use ==
        //either call .get() method after calling findFirst -> throws error if id isn't found.
        // or chain an orElse method to return something if nothing is found
        return users.stream().filter(user->user.getId().equals(id)).findFirst().orElse(null);
    }

    public User addUser( User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteUserById(int id) {
        users.removeIf(user->user.getId()==id);
    }
}
