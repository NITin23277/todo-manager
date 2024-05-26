package com.lcwd.todo.controllers;

import com.lcwd.todo.models.Todo;
import com.lcwd.todo.services.TodoService;
import com.lcwd.todo.services.impl.TodoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todo")
public class TodoController {


    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService ;

    Random random = new Random();

    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){
//        String str = null ;
//        logger.info("{}" , str.length());

//        Integer.parseInt("1233dfs") ;
        //create todo
        int id = random.nextInt(999999);
        todo.setId(id);
        //create date with system default current date
        Date curr_Date = new Date();
        logger.info("current date {}" , curr_Date);
        logger.info("todo date {}" , todo.getToDoDate());
        todo.setAddedDate(curr_Date);
        logger.info("Create Todo") ;
        Todo todo1 = todoService.createTodo(todo);
        return new ResponseEntity<>(todo1 , HttpStatus.CREATED) ;
    }

    //get all todo metthod
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodoHandler() {
        List<Todo> allTodo = todoService.getAllTodos();
        return new ResponseEntity<>(allTodo , HttpStatus.OK);
    }

    //get single todo
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getSingleTodoHandler(@PathVariable int todoId) throws ParseException {
        Todo todo = todoService.getTodo(todoId);
        return ResponseEntity.ok(todo);
    }

    //udate todo

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoHandler(@RequestBody Todo todoWithNewDetails , @PathVariable int todoId ){
        Todo updatedTodo = todoService.updateTodo(todoId , todoWithNewDetails);
        return ResponseEntity.ok(updatedTodo);
    }

    // delete hanfeler

    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodoHandler(@PathVariable int todoId){
       todoService.deleteTodo(todoId);
       return ResponseEntity.ok("Todo Successfully deleted") ;
    }


    //exceptionHADDLER

//    @ExceptionHandler(value = {NullPointerException.class , NumberFormatException.class } )
//    public ResponseEntity<String> nullPointerExceptionHandler(Exception ex ) {
//        System.out.println(ex.getMessage());
//        System.out.println("Null pointer exception generated");
//        return new ResponseEntity<>("Null pointer exception generated" + ex.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR )  ;
//    }

//    //exceptionHADDLER
//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity<String> numberFormatExceptionHandler(NumberFormatException ex ) {
//        System.out.println(ex.getMessage());
//        System.out.println("Null pointer exception generated");
//        return new ResponseEntity<>("Null pointer exception generated" + ex.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR )  ;
//    }



}
