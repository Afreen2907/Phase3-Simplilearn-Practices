package com.simplilearn.workshop.todos;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.domain.Todo;
import com.simplilearn.workshop.errors.TodoNotFoundException;
import com.simplilearn.workshop.service.TodoService;

@RestController
public class TodoResource {

	@Autowired
	private TodoService todoService;
	
	//HTTP Method: GET
	//URI: /users/afreen/todos
	@GetMapping(path="/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoService.findAll();
	}
	
	//HTTP Method: GET
	//URI:/users/afreen/todos/1
	@GetMapping(path="/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		
		Todo theTodo = todoService.findById(id);
		if(theTodo == null) {
			throw new TodoNotFoundException("id - " + id );
		}
		return theTodo;
	}
	
	//HTTP Method: PUT
	//URI: /users/{username}/todos/{id}
	@PutMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo theTodo) {
		Todo findTodo = todoService.findById(id);
		if (findTodo == null) {
			throw new TodoNotFoundException("id - " + id );
		} else {
			findTodo.setDescription(theTodo.getDescription());
		}
		Todo savedTodo = todoService.save(findTodo);
		
		return new ResponseEntity(savedTodo, HttpStatus.OK);
	}
	
	
	//HTTP Method: DELETE
	//URI: /users/{username}/todos/{id}
	
	@DeleteMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Todo> deleteTodo(@PathVariable String username, @PathVariable long id) {
		todoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	
	//HTTP Method: POST
	//URI: /users/afreen/todos
	//Request Body --> JSON Data {}
	@PostMapping(path= "/users/{username}/todos")
	public ResponseEntity createTodo(@PathVariable String username, @Valid @RequestBody Todo theTodo) {
		
		Todo savedTodo = todoService.save(theTodo);
		//Response header  shld contain the header
		//Status code: 201
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTodo.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
