package com.mihirsingh.todomanager.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mihirsingh.todomanager.models.Todo;
import com.mihirsingh.todomanager.services.TodoService;
//import com.mihirsingh.todomanager.services.impl.TodoServiceImpl;

@RestController
@RequestMapping("/todo")
public class Homecontroller {

	@Autowired
	private TodoService todoService;

	Random random = new Random();

	// JdbcTemplate jdbcTemplate  = new JdbcTemplate();

	@PostMapping("/create")
	public ResponseEntity<Todo> createHandler(@RequestBody Todo todo) {
		int id = random.nextInt(99999);
		todo.setTodoId(id);
		Todo createTodo = todoService.createUsertask(todo);
		return new ResponseEntity<Todo>(createTodo, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Todo>> getAllHandler() {
		List<Todo> getTodo = todoService.getUserTaskList();
		return new ResponseEntity<>(getTodo, HttpStatus.OK);
	}

	@GetMapping("/{todoId}")
	public ResponseEntity<Todo> getSingleHandler(@PathVariable int todoId) {
		Todo getsingleTodo = todoService.getsingleUserTask(todoId);
		return new ResponseEntity<Todo>(getsingleTodo, HttpStatus.OK);
	}

	@PutMapping("/{todoId}")
	public ResponseEntity<Todo> updateHandler(@RequestBody Todo newTodoDetails, @PathVariable int todoId) {
		Todo updatetodo = todoService.updatetodoUserTask(newTodoDetails, todoId);
		return new ResponseEntity<Todo>(updatetodo, HttpStatus.OK);
	}

	@DeleteMapping("/{todoId}")
	public ResponseEntity<String> deleteHandlrr(@PathVariable int todoId) {
		todoService.deleteUserTask(todoId);
		return new ResponseEntity<String>("Todo  Successfully Deleted", HttpStatus.OK);
	}

}
