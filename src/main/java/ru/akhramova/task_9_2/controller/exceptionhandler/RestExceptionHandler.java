package ru.akhramova.task_9_2.controller.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.akhramova.task_9_2.exception.InvalidCredentials;
import ru.akhramova.task_9_2.exception.UnauthorizedUser;
import ru.akhramova.task_9_2.model.ErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<ErrorResponse> invalidCredentials
            (InvalidCredentials exception) {
        return new ResponseEntity<>(new ErrorResponse
                (HttpStatus.BAD_REQUEST.value(), exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseEntity<ErrorResponse> unauthorizedUser
            (UnauthorizedUser exception) {
        return new ResponseEntity<>(new ErrorResponse
                (HttpStatus.UNAUTHORIZED.value(), exception.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<ErrorResponse> badRequestException
            (Exception exception) {
        return new ResponseEntity<>(new ErrorResponse
                (HttpStatus.BAD_REQUEST.value(), exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
