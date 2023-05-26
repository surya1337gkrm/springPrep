package com.surya.springboot.MyFirstWebApp.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService=toDoService;
    }

    @RequestMapping("get-todos")
    public String getTodos(ModelMap model){
        List<Todo> todos=toDoService.getTodosByUsername("Surya");
        model.addAttribute("todos",todos);
        return "listTodos";
    };
}
