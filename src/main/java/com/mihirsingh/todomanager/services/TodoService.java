package com.mihirsingh.todomanager.services;

import java.util.List;

import com.mihirsingh.todomanager.models.Todo;

public interface TodoService {

    public Todo createUsertask(Todo todo);

    public List<Todo> getUserTaskList();

    public Todo getsingleUserTask(int todoId);

    public Todo updatetodoUserTask(Todo newTodoDetails, int todoId);

    public void deleteUserTask(int todoId);
}
