package com.example.SpringWebApplication.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "mayank","Learn AWS",
							LocalDate.now().plusYears(1), false ));
		todos.add(new Todo(++todosCount, "mayank","Learn DevOps",
				LocalDate.now().plusYears(2), false ));
		todos.add(new Todo(++todosCount, "mayank","Learn Full Stack Development",
				LocalDate.now().plusYears(3), false ));
	}
	
	public List<Todo> findByUsername(String username){
		return todos
				.stream()
				.filter(
						todo ->
								todo.getUsername()
										.equalsIgnoreCase(username))
				.toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}

	public void deleteToDoById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}
	public Optional<Todo> findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		return todos.stream().filter(predicate).findFirst();
	}

	public void editToDo (Todo todo) {
		deleteToDoById(todo.getId());
		todos.add(todo);
	}

}