package com.lcwd.todo.services.impl;

import com.lcwd.todo.exceptions.ResourceNotFoundException;
import com.lcwd.todo.models.Todo;
import com.lcwd.todo.services.TodoService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;

//@Component
@Service
public class TodoServiceImpl implements TodoService {

    // create fake database to store list
    List<Todo> todos = new ArrayList<>();

    Logger logger =  LoggerFactory.getLogger(TodoServiceImpl.class);
    //create todo method
    public Todo createTodo (Todo todo){
        //create...
        //change for database
        todos.add(todo);
        logger.info("Todos {}" , this.todos.toString() );
        return todo ;
    }

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo getTodo(int todoId) {
        Todo todo = todos.stream().filter(t -> todoId == t.getId()).findAny().orElseThrow(() -> new ResourceNotFoundException("todo do not found" , HttpStatus.NOT_FOUND)) ;
        logger.info("TODO : {}" , todo);
        return todo;
    }

    public Todo updateTodo(int todoId, Todo todo) {
        List<Todo> newUpdate_List = todos.stream().map(t->{
            if(t.getId()==todoId){
                //perform update
                t.setContent(todo.getContent());
                t.setTitle(todo.getTitle());
                t.setStatus(todo.getStatus());
                return t ;
            }
            else{
                return t ;
            }
        }).collect(Collectors.toList());
        todos = newUpdate_List;
        todo.setId(todoId);
        return todo ;
    }

    public void deleteTodo(int todoId) {
        logger.info("deleting todo");
        List<Todo> newList = todos.stream().filter(t -> t.getId() != todoId).collect(Collectors.toList());
        todos = newList;
    }
}
