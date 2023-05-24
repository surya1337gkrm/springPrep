package com.surya.springboot.MyFirstWebApp.login;

import com.surya.springboot.MyFirstWebApp.Auth.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {

    private Auth auth;

    public LoginController(Auth auth){
        this.auth=auth;
    }
    @RequestMapping(value="login",method=RequestMethod.GET)
    public String getLogin(){
        return "login";
    }

    @RequestMapping(value="login",method= RequestMethod.POST)
    //either use map or declare individually @RequestParam String username, @RequestParam String password
    public String postLogin(@RequestParam Map<String,String> formData,ModelMap model){

        if(auth.login(formData.get("name"),formData.get("password"))){
            model.put("name",formData.get("name"));
            return "welcome";
        }
        model.put("errorMessage","Invalid Credentials. Please Try Again.");
        return "login";
    }
}
