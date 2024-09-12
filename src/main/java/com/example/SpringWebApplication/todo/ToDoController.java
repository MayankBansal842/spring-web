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
    public String addToDoPage() {
        return "addToDo";
    }

    @PostMapping("add-to-do")
    public String addNewItemSubmit(
            @SessionAttribute("name") String username,
            @RequestParam String description,
            @RequestParam LocalDate dueDate,
            @RequestParam boolean completed,
            ModelMap modelMap) {
//        log.info((String)modelMap.get("name"));
//        log.info("Username is : " + username);
        toDoService.addToDo(username, description, dueDate, completed);
        return "redirect:/to-dos";
    }
}
