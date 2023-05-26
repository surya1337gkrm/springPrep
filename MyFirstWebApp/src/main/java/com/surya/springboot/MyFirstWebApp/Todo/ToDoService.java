package com.surya.springboot.MyFirstWebApp.Todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static final List<Todo> todos = new ArrayList<>();

    //initiate the static variables
    static{
        todos.add(new Todo(1,"Surya","Learn Java", LocalDate.now().plusMonths(2),true));
                todos.add(new Todo(2,"Surya","Learn Springboot", LocalDate.now().plusMonths(2),false));
                        todos.add(new Todo(3,"Surya","Learn Docker", LocalDate.now().plusMonths(2),false));

    }

    public List<Todo> getTodosByUsername(String username){
        return todos;
    }

}
