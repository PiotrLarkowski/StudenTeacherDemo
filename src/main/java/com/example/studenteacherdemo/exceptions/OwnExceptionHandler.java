package com.example.studenteacherdemo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class OwnExceptionHandler {

    @ExceptionHandler({StudentException.class, TeacherException.class})
    public ResponseEntity<?> getResponseHttpNotFound() {
        log.error("Student with given id not found!");
        return ResponseEntity.notFound().build();
    }

}
