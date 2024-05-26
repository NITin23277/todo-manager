package com.lcwd.todo;

import com.lcwd.todo.dao.TodoDao;
import com.lcwd.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger((TodoManagerApplication.class));
	@Autowired
	private TodoDao todoDao  ;
	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("aPPLICATION STARTED :  ");
//		JdbcTemplate template = todoDao.getTemplate() ;
//	    logger.info("Template Objext : {}" , template.getDataSource()) ;

//		Todo todo = new Todo();
//
//		todo.setId(123);
//		todo.setTitle("Java placement cource");
//		todo.setContent("I have to learn");
//		todo.setStatus("Pending");
//		todo.setAddedDate(new Date());
//		todo.setToDoDate(new Date() );
//
//		todoDao.saveTodo(todo) ;

//		Todo todo = todoDao.getTodo(1234);
//		logger.info("TODO : {}" , todo);
//		todo.setTitle("Learn spring boot");
//		todo.setContent("I have  to lear spring");
//		todo.setStatus("Done");
//		todo.setAddedDate(new Date());
//		todo.setToDoDate(new Date());
//		todoDao.updateTodo(1234 , todo) ;
//		todoDao.deleteTodo(1234);
//		List<Todo> allTodos =  todoDao.getAllTodo();
//		logger.info("TODOS : {}" , allTodos) ;

//		todoDao.deleteMultiple(new int[]{3,123});

//		Todo todo = todoDao.getTodo(790066);
//        logger.info( "{}" , todo) ;
//		List<Todo> allTodo = todoDao.getAllTodo();
//		logger.info("{}" , allTodo ) ;



	}
}
