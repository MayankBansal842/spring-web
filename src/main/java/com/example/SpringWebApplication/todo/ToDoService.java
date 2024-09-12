package com.example.SpringWebApplication.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<>();
    private static int toDoCount=0;
    static {
        todos.add(new ToDo(++toDoCount,"mayank", "Learn Spring", LocalDate.now().plusMonths(1),false));
        todos.add(new ToDo(++toDoCount,"mayank", "Learn DevOps", LocalDate.now().plusMonths(12),false));
        todos.add(new ToDo(++toDoCount,"mayank", "Learn AWS", LocalDate.now().plusMonths(3),false));

    }

    public List<ToDo> getAllToDos(){
        return todos;
    }

    public void addToDo(String username, String description, LocalDate dueDate, boolean isComplete) {
        ToDo toDo = new ToDo(++toDoCount, username, description, dueDate, isComplete);
        todos.add(toDo);
    }
}
