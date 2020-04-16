package com.agustincantero.restwebservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agustincantero.restwebservice.entity.Todo;
import com.agustincantero.restwebservice.services.HarcodedService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

	@Autowired
	private HarcodedService todoService;
	
	@GetMapping("users/{userName}/todos")
	public List<Todo> getAllTodos(String userName) {
		return todoService.findAll();
		
	}
}
