package com.project.tasktracker.controllers;


import com.project.tasktracker.domain.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleExceptions(
            RuntimeException excpt, WebRequest request
    ) {
       ErrorResponse errorResponse = new ErrorResponse(
               HttpStatus.BAD_REQUEST.value(),
               excpt.getMessage(),
               request.getDescription(false)
       );

       return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
