package com.agustincantero.restwebservice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agustincantero.restwebservice.entity.Todo;

@Service
public class HarcodedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "Agustin", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "Agustin", "Learn about MicroServices", new Date(), false));
		todos.add(new Todo(++idCounter, "Agustin", "Learn about Angular", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		
		Todo todo = findById(id);
		if (todo != null) {
			todos.remove(todo);
		}
		return todo;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
