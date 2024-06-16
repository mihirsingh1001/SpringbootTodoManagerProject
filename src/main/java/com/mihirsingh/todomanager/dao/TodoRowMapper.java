package com.mihirsingh.todomanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.mihirsingh.todomanager.models.Todo;

public class TodoRowMapper implements RowMapper<Todo> {

    @Override
    @Nullable
    public Todo mapRow( ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub

        Todo todo = new Todo();
        todo.setTodoId(rs.getInt("id"));
        todo.setTodoMessage(rs.getString("message"));
        todo.setStatus(rs.getString("status"));
        return todo;
    }

}
