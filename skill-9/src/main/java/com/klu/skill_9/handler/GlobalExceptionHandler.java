package com.klu.skill_9.handler;


import com.klu.skill_9.exception.InvalidInputException;
import com.klu.skill_9.exception.StudentNotFoundException;
import com.klu.skill_9.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Task 4 — handle StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
            LocalDateTime.now(),
            ex.getMessage(),
            HttpStatus.NOT_FOUND.value()  // 404
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Task 5 — handle InvalidInputException
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInput(InvalidInputException ex) {
        ErrorResponse error = new ErrorResponse(
            LocalDateTime.now(),
            ex.getMessage(),
            HttpStatus.BAD_REQUEST.value()  // 400
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}