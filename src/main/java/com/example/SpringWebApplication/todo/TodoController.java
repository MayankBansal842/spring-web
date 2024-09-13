package com.example.SpringWebApplication.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class TodoController {

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;


	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("mayank");
		model.addAttribute("todos", todos);
		return "toDos";
	}

	//GET, POST
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = (String) model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String username = (String) model.get("name");
		todoService.addTodo(username, todo.getDescription(),
				LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "delete-todo", method = RequestMethod.GET)
	public String deleteToDo(@RequestParam int id) {
		todoService.deleteToDoById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "edit-todo", method = RequestMethod.GET)
	public String editToDo(@RequestParam int id, ModelMap model) {
		Optional<Todo> optTodo = todoService.findById(id);
		if (optTodo.isPresent()) {
			String username = (String) model.get("name");
			Todo todo = optTodo.get();
			model.put("todo", todo);
			todoService.deleteToDoById(id);
			return "todo";
		} else {
			return "redirect:list-todos";
		}
	}

	@RequestMapping(value = "edit-todo", method = RequestMethod.POST)
	public String editTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		String username = (String) model.get("name");
		todoService.addTodo(username,todo.getDescription(),todo.getTargetDate(),todo.isDone());
		return "redirect:list-todos";
	}
}
