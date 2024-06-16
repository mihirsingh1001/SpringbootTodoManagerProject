package com.mihirsingh.todomanager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mihirsingh.todomanager.dao.TodoDao;
import com.mihirsingh.todomanager.models.Todo;
import com.mihirsingh.todomanager.services.TodoService;

@Service
//@Primary
public class TodoDaoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    @Override
    public Todo createUsertask(Todo todo) {
        // TODO Auto-generated method stu
        return todoDao.saveTodo(todo);
    }

    @Override
    public List<Todo> getUserTaskList() {
        // TODO Auto-generated method stub
        return todoDao.getAllTodo();
    }

    @Override
    public Todo getsingleUserTask(int todoId) {
        // TODO Auto-generated method stub
    
        return todoDao.getSingleTodo(todoId);
    }

    @Override
    public Todo updatetodoUserTask(Todo newTodoDetails, int todoId) {
        // TODO Auto-generated method stub
        
        return todoDao.updateTodo(newTodoDetails,todoId);
    }

    @Override
    public void deleteUserTask(int todoId) {
        // TODO Auto-generated method stu
    }

}
