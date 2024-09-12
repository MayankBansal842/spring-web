package com.example.SpringWebApplication.todo;

import java.time.LocalDate;

public class ToDo {

    private int id;
    private String username;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public ToDo(int id, String username, String description, LocalDate dueDate, boolean completed) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Username : " + getUsername() + "\nDescription : " + getDescription() + "\nDueDate" + dueDate.toString() + "\nIs Completed: " + isCompleted();
    }
}
