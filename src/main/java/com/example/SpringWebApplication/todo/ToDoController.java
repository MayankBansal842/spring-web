package com.example.SpringWebApplication.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        super();
        this.toDoService = toDoService;
    }

    @GetMapping("to-dos")
    public String listToDos(ModelMap modelMap) {
        modelMap.put("todos",toDoService.getAllToDos());
        return "toDos";
    }
    @GetMapping("add-to-do")
    public String addToDoPage() {
        return "addToDo";
    }

    @PostMapping("add-to-do")
    public String addNewItemSubmit() {
        return "redirect:/to-dos";
    }
}
