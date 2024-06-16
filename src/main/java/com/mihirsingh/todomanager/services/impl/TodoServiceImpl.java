package com.mihirsingh.todomanager.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mihirsingh.todomanager.models.Todo;
import com.mihirsingh.todomanager.services.TodoService;

//@Component
@Service
public class TodoServiceImpl implements TodoService  {

	List<Todo> todo_list = new ArrayList<Todo>();

	public Todo createUsertask(Todo todo) {
		todo_list.add(todo);
		System.out.println(todo);
		return todo;
	}

	public List<Todo> getUserTaskList() {
		System.out.println(todo_list);
		return todo_list;
	}

	public Todo getsingleUserTask(int todoId) {
		Todo todo = todo_list.stream().filter(t -> todoId == t.getTodoId()).findAny().get();
		return todo;
	}

	public Todo updatetodoUserTask(Todo newTodoDetails, int todoId) {
		List<Todo> newUpdateList = todo_list.stream().map(t -> {
			if (t.getTodoId() == todoId) {
//				t.setTodoId(newTodoDetails.getTodoId());
				t.setTodoMessage(newTodoDetails.getTodoMessage());
				t.setStatus(newTodoDetails.getStatus());
				return t;
			} else {
				return t;
			}
		}).collect(Collectors.toList());

		todo_list = newUpdateList;
		newTodoDetails.setTodoId(todoId);
		return newTodoDetails;

	}

	public void deleteUserTask(int todoId) {
		List<Todo> newtodo_List = todo_list.stream().filter(t -> t.getTodoId() != todoId).collect(Collectors.toList());
		todo_list = newtodo_List;

	}

}
