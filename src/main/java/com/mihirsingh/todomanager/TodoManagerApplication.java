package com.mihirsingh.todomanager;

//import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mihirsingh.todomanager.dao.TodoDao;
//import com.mihirsingh.todomanager.models.Todo;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(TodoManagerApplication.class);

	@Autowired
		private TodoDao todoDao;

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// JdbcTemplate template = todoDao.getTemplate();
		// logger.info("Template info ::: " + template.toString());



		// Insert todo 
		// Todo todo = new Todo();
		// todo.setTodoId(2);
		// todo.setTodoMessage("Complete the learning of spring jdbc");
		// todo.setStatus("In process");

		// todoDao.saveTodo(todo);



		// Single Todo
		// Todo todo1 = todoDao.getSingleTodo(2);
		// logger.info("TODO : " + todo1);



		// todo1.setTodoMessage("Complete the Payby task");
		// todo1.setStatus("Completed");
		// todoDao.updateTodo(21, todo1);



		// Delete Single todo
		//todoDao.deleteTodo(21);



		// All Todo
		// List<Todo> todogetAll = todoDao.getAllTodo();
		// logger.info("ALL TODOS ::: " + todogetAll);
	}

}
