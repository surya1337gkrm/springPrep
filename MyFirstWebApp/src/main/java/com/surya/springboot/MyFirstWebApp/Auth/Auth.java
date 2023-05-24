package com.surya.springboot.MyFirstWebApp.Auth;

import org.springframework.stereotype.Service;

@Service
public class Auth {
    public boolean login(String username,String password){
        return username.equalsIgnoreCase("surya") && password.equalsIgnoreCase("surya");
    }
}
