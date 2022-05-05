package com.example.DynamicProgrammingCoders.exception;

import com.example.DynamicProgrammingCoders.dto.reponse.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(ProblemDoesntExist.class)
    public ResponseEntity<?> ProblemDoesntExist(Exception e){
        return new ResponseEntity<>(new ExceptionResponseDTO(e.getMessage(),"400"), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserDoesntExist.class)
    public ResponseEntity<?> UserDoesntExist(Exception e){
        return new ResponseEntity<>(new ExceptionResponseDTO(e.getMessage(),"400"), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<?> UserAlreadyExist(Exception e){
        return new ResponseEntity<>(new ExceptionResponseDTO(e.getMessage(),"400"), HttpStatus.BAD_REQUEST);
    }
}
