package com.agustincantero.restwebservice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agustincantero.restwebservice.entity.Todo;

@Service
public class HarcodedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounte = 0;
	
	static {
		todos.add(new Todo(++idCounte,"Agustin", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounte,"Agustin", "Learn about MicroServices", new Date(), false));
		todos.add(new Todo(++idCounte,"Agustin", "Learn about Angular", new Date(), false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
}
