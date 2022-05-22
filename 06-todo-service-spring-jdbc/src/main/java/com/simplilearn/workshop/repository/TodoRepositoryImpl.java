package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.domain.Todo;

@Repository(value="todoRepository")
public class TodoRepositoryImpl implements TodoRepository {
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	public TodoRepositoryImpl (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getTodosCount() {
		int count = this.jdbcTemplate.queryForObject("select count(*) from todos", Integer.class);
		return count;
	}
	
	public final RowMapper<Todo> todoRowMapper = (rs, rowNum)-> {
		Todo todo = new Todo();
		todo.setId(rs.getLong("id"));
		todo.setDescription(rs.getString("description"));
		todo.setUsername(rs.getString("username"));
		todo.setTargetDate(rs.getDate("targetDate"));
		todo.setDone(rs.getBoolean("isDone"));
		return todo;
	};

	@Override
	public List<Todo> findAll() {
		List <Todo> todos = this.jdbcTemplate.query("select * from todos", todoRowMapper );
		return todos;
	}

	@Override
	public Todo save(Todo theTodo) {
	   this.jdbcTemplate.update("insert into todos (username, description, isDone, targetDate) values(?,?,?,?)"
			  , theTodo.getUsername(), theTodo.getDescription(), theTodo.isDone(), theTodo.getTargetDate());
	  
		
		return null;
	}

	@Override
	public Todo deleteById(long theId) {
		String deleteQuery = "delete from todos where id = ?";
		this.jdbcTemplate.update(deleteQuery, theId);
		return null;
	}

	@Override
	public Todo findById(long theId) {
		Todo theTodo = this.jdbcTemplate.queryForObject("select * from todos where id  = ?", todoRowMapper, theId);
		return theTodo;
	}

}
