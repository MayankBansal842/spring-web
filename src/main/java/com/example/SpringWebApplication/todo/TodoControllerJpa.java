package com.example.SpringWebApplication.todo;

import com.example.SpringWebApplication.todo.repository.ToDoRepository;
import jakarta.validation.Valid;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
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
public class TodoControllerJpa {

	private static final Logger log = LoggerFactory.getLogger(TodoControllerJpa.class);

	public TodoControllerJpa(ToDoRepository toDoRepository) {
		super();
		this.toDoRepository = toDoRepository;
	}

	private ToDoRepository toDoRepository;

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUserName();
		List<Todo> todos = toDoRepository.findAllByUsername(username);
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
		todo.setUsername(username);
		toDoRepository.save(todo);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "delete-todo", method = RequestMethod.GET)
	public String deleteToDo(@RequestParam int id) {
		String username = getLoggedInUserName();
		toDoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "edit-todo", method = RequestMethod.GET)
	public String editToDo(@RequestParam int id, ModelMap model) {
		Optional<Todo> optTodo = toDoRepository.findById(id);
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
		todo.setUsername(getLoggedInUserName());
		toDoRepository.save(todo);
		return "redirect:list-todos";
	}

	public String getLoggedInUserName() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
