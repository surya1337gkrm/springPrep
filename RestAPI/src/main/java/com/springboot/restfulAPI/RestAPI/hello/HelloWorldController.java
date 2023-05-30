package com.springboot.restfulAPI.RestAPI.hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @RequestMapping(value="/hello-world",method= RequestMethod.GET)
    public String helloWorld(){
        return "Hello World!";
    }

    @RequestMapping(value="/hello-world-bean",method=RequestMethod.GET)
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World - Bean.");
    }

    @GetMapping("/hello/{name}")
    public HelloWorldBean helloWorld(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello, %s",name));
    }

    //use this endpoint to check if user is loggedin.
    @GetMapping("/basicauth")
    public String basicAuth(){
        return "Success";
    }

    @GetMapping("/hello")
    public HelloWorldBean helloWorldParams(@RequestParam(required = false) String name){
        if(name!=null){
            return new HelloWorldBean(String.format("Hello, %s",name));
        }
        return new HelloWorldBean("Hello.");
    }
}
