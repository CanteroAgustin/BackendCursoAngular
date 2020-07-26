package com.agustincantero.restwebservice.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agustincantero.restwebservice.entity.Todo;
import com.agustincantero.restwebservice.repository.TodoJpaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoJpaResource {

//	@Autowired
//	private HarcodedService todoService;

	@Autowired
	private TodoJpaRepository todoJpaRepository;

	@GetMapping("/jpa/users/{userName}/todos/{id}")
	public Todo getTodo(@PathVariable String userName, @PathVariable long id) {
		return todoJpaRepository.findById(id).get();
		// return todoService.findById(id);
	}

	@GetMapping("/jpa/users/{userName}/todos")
	public List<Todo> getAllTodos(@PathVariable String userName) {
		return todoJpaRepository.findByUsername(userName);
		// return todoService.findAll();
	}

	@DeleteMapping("/jpa/users/{userName}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable long id) {
		// Todo todo = todoService.deleteById(id);

		todoJpaRepository.deleteById(id);

		return ResponseEntity.noContent().build();
		// return ResponseEntity.notFound().build();
	}

	@PutMapping("/jpa/users/{userName}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String userName, @PathVariable long id,
			@RequestBody Todo todo) {
		//Todo todoUpdated = todoService.save(todo);
		Todo todoUpdated = todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);

	}

	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
		
		//Todo createdTodo = todoService.save(todo);
		System.out.println(username);
		
		todo.setUsername(username);
		System.out.println(username);
		System.out.println(todo.getUsername());
		Todo createdTodo = todoJpaRepository.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

}
