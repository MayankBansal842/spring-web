package com.example.SpringWebApplication.todo.repository;

import com.example.SpringWebApplication.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<Todo,Integer> {
    public List<Todo> findAllByUsername(String username);
    public void deleteByUsernameAndId(String username, Integer id);
}
