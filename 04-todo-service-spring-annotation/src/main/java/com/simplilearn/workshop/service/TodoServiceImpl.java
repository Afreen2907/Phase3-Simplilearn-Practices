package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Todo;
import com.simplilearn.workshop.repository.TodoRepository;
import com.simplilearn.workshop.repository.TodoRepositoryImpl;

@Service(value="todoService")
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository; // property name used in application context configuration

//	public void setTodoRepository(TodoRepository todoRepository) {
//		System.out.println("setter method is called");
//		this.todoRepository = todoRepository;
//	}
	
	
	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository) {
	
		this.todoRepository = todoRepository;
	}



//	public TodoServiceImpl() {
//		this.todoRepository = todoRepository;
//	}

	@Override
	public List<Todo> findAll() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}

	

	@Override
	public Todo save(Todo theTodo) {
		// TODO Auto-generated method stub
		return todoRepository.save(theTodo);
	}

	@Override
	public Todo deleteById(long theId) {
		// TODO Auto-generated method stub
		return todoRepository.deleteById(theId);
	}

	@Override
	public Todo findById(long theId) {
		// TODO Auto-generated method stub
		return todoRepository.findById(theId);
	}

	// follows the separation of concern principle
	// can add more business logics and use cases here
}
