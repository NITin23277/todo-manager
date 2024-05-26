package com.lcwd.todo.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionalHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionalHandler.class);
    // we have to create handler method for specific exception

     @ExceptionHandler(value = {NullPointerException.class , NumberFormatException.class } )
     public ResponseEntity<String> nullPointerExceptionHandler(Exception ex ) {
         System.out.println(ex.getMessage());
         logger.info( "Null pointer exception generated");
         return new ResponseEntity<>("Null pointer exception generated" + ex.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR )  ;
      }

      //handling Resource not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
         logger.error("Error {} " , ex.getMessage());
         ExceptionResponse response = new ExceptionResponse();
         response.setMessage(ex.getMessage());
         response.setStatus(HttpStatus.NOT_FOUND);
         response.setSuccess(false);
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);



    }

}
