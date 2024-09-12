package com.example.SpringWebApplication.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.LocalDate;
import java.util.Locale;

@Controller
public class ToDoController {

    private static final Logger log = LoggerFactory.getLogger(ToDoController.class);
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
    public String addToDoPage(@SessionAttribute("name") String username, ModelMap modelMap) {
        ToDo toDo = new ToDo(0,username,"",LocalDate.now().plusYears(1),false);
        modelMap.put("toDo",toDo);
        return "addToDo";
    }

//    Without direct bindings
//    @PostMapping("add-to-do")
//    public String addNewItemSubmit(
//            @SessionAttribute("name") String username,
//            @RequestParam String description,
//            @RequestParam LocalDate dueDate,
//            @RequestParam boolean completed,
//            ModelMap modelMap) {
//        toDoService.addToDo(username, description, dueDate, completed);
//        return "redirect:/to-dos";
//    }

//    With binding
    @PostMapping("add-to-do")
    public String addNewItemSubmit(ModelMap modelMap, ToDo toDo, @SessionAttribute("name") String username) {
        toDoService.addToDo(username,toDo.getDescription(),LocalDate.now().plusYears(1),false);
        return "redirect:/to-dos";
    }

}
