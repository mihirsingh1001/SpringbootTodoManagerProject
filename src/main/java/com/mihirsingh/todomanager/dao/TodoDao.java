package com.mihirsingh.todomanager.dao;

import java.util.List;
//import java.util.Map;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mihirsingh.todomanager.models.Todo;

//@Component
@Repository
public class TodoDao {

    Logger logger = LoggerFactory.getLogger(TodoDao.class);

    private JdbcTemplate template;

    public TodoDao(@Autowired JdbcTemplate template) {
        this.template = template;

        // create query
        String createTable = "create table IF NOT EXISTS todos(id int primary key, message varchar(200) not null, status varchar(200) not null)";
        int update = template.update(createTable);
        logger.info("TODO table created");
        logger.info("UPDATE ::: " + update);

    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // save todo in database
    public Todo saveTodo(Todo todo) {

        String insertQuery = " insert into todos (id, message, status) values (?,?,?) ";

        int rows = template.update(insertQuery, todo.getTodoId(), todo.getTodoMessage(), todo.getStatus());

        logger.info("Rows affected :::: " + rows);

        return todo;
    }

    // Get single todo from database
    public Todo getSingleTodo(int id) {
        String query = "select * from todos where id=?";
        Todo todo = template.queryForObject(query, new TodoRowMapper(), id);
        return todo;
    }

    // Get all todo from database;
    public List<Todo> getAllTodo() {
        String query = "select * from todos";
        List<Todo> todos = template.query(query, new TodoRowMapper());
        return todos;
    }

    // updatee single todo form database
    public Todo updateTodo(Todo newTodo, int id) {
        String query = "update todos set message=?, status=? where id=?";
        int update = template.update(query, newTodo.getTodoMessage(), newTodo.getStatus(), newTodo.getTodoId());
        logger.info("UPDATE ::: " + update);
        newTodo.setTodoId(id);
        return newTodo;
    }

    //delete single todo from database
    public void deleteTodo(int id) {
        String query = "delete from todos where id=?";
        int delete = template.update(query, id);
        logger.info("DELETE ::: " + delete);
    }
}
