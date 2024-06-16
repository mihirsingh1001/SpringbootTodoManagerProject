package com.mihirsingh.todomanager.services.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mihirsingh.todomanager.dao.TodoJpaRepository;
import com.mihirsingh.todomanager.models.Todo;
import com.mihirsingh.todomanager.services.TodoService;

@Service
@Primary
public class TodoJpaServiceImpl implements TodoService {

    @Autowired
    private TodoJpaRepository jpaRepository;

    org.slf4j.Logger logger = LoggerFactory.getLogger(TodoJpaServiceImpl.class);

    @Override
    public Todo createUsertask(Todo todo) {
        // TODO Auto-generated method stub
        return jpaRepository.save(todo);
    }

    @Override
    public List<Todo> getUserTaskList() {
        // TODO Auto-generated method stub
        return jpaRepository.findAll();
    }

    @Override
    public Todo getsingleUserTask(int todoId) {
        // TODO Auto-generated method stub
        Todo singleTodo = jpaRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Error!! No such ID is present."));
        return singleTodo;
    }

    @Override
    public Todo updatetodoUserTask(Todo newTodoDetails, int todoId) {
        // TODO Auto-generated method stub
        Todo oldTodoDetails = jpaRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Error!! No such ID is present."));
        oldTodoDetails.setTodoMessage(newTodoDetails.getTodoMessage());
        oldTodoDetails.setStatus(newTodoDetails.getStatus());

        Todo newTodo = jpaRepository.save(oldTodoDetails);

        return newTodo;
    }

    @Override
    public void deleteUserTask(int todoId) {
        // TODO Auto-generated method stub

        jpaRepository.deleteById(todoId);

        logger.info("Todo is deleted successfully");

    }

}
