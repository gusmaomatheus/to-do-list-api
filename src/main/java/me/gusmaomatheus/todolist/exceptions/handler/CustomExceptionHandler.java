package me.gusmaomatheus.todolist.exceptions.handler;

import me.gusmaomatheus.todolist.exceptions.TitleAlreadyExistsException;
import me.gusmaomatheus.todolist.exceptions.TitleLengthException;
import me.gusmaomatheus.todolist.exceptions.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(TitleAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> taskAlreadyExists(TitleAlreadyExistsException exception) {
        String reason = exception.getMessage();
        HttpStatus status = HttpStatus.CONFLICT;
        LocalDateTime occurrence = LocalDateTime.now();
        ExceptionResponse response = new ExceptionResponse(reason, status, occurrence);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(TitleLengthException.class)
    public ResponseEntity<ExceptionResponse> titleLengthInvalid(TitleLengthException exception) {
        String reason = exception.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        LocalDateTime occurrence = LocalDateTime.now();
        ExceptionResponse response = new ExceptionResponse(reason, status, occurrence);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
