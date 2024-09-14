package com.example.SpringWebApplication.todo;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
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

	private static final Logger log = LoggerFactory.getLogger(TodoController.class);

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername(getLoggedInUserName());
		model.addAttribute("todos", todos);
		return "toDos";
	}

	//GET, POST
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUserName();
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUserName();
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
			Todo todo = optTodo.get();
			log.info(todo.toString());
			model.put("todo", todo);
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
		todoService.editToDo(todo);
		return "redirect:list-todos";
	}

	public String getLoggedInUserName() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
