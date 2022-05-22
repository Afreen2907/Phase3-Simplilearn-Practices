package com.simplilearn.workshop;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplilearn.workshop.config.TodoServiceConfig;
import com.simplilearn.workshop.domain.Todo;
import com.simplilearn.workshop.service.TodoService;
import com.simplilearn.workshop.service.TodoServiceImpl;


public class Program {

	public static void main(String[] args) {
		
		// create and configure beans
		 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
				 ctx.register(TodoServiceConfig.class);;
		    
		    ctx.refresh();
		
		// retrieve configured instance
		TodoService theTodoService = ctx.getBean("todoService", TodoServiceImpl.class);
	
		
		
		Todo theTodo = new Todo();
		
		theTodo.setDescription("Learn to Run!");
		theTodo.setUsername("simplilearn");
		theTodo.setTargetDate(new Date());
		theTodoService.save(theTodo);
		
		System.out.println(theTodoService.findAll().get(0).getDescription());
		System.out.println("The no of todo's is: " + theTodoService.getTodosCount());
		System.out.println(theTodoService.findById(2).getDescription());
		
		theTodoService.deleteById(1L);
		System.out.println("The no of todo's is: " + theTodoService.getTodosCount());

	}

}
