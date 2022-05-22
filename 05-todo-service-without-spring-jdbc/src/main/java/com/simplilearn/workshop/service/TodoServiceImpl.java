package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.domain.Todo;
import com.simplilearn.workshop.repository.TodoRepository;
import com.simplilearn.workshop.repository.TodoRepositoryImpl;

public class TodoServiceImpl implements TodoService {

	private TodoRepository todoRepo = new TodoRepositoryImpl();
	@Override
	public List<Todo> findAll() {
		// TODO Auto-generated method stub
		return todoRepo.findAll();
	}

	@Override
	public Todo save(Todo theTodo) {
		// TODO Auto-generated method stub
		return todoRepo.save(theTodo);
	}

	@Override
	public Todo deleteById(long theId) {
		// TODO Auto-generated method stub
		return todoRepo.deleteById(theId);
	}

	@Override
	public Todo findById(long theId) {
		// TODO Auto-generated method stub
		return todoRepo.findById(theId);
	}

	//follows the separation of concern principle
	//can add more business logics and use cases here
}
