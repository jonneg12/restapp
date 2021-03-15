package ru.netology.restapp.excetions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("ru.netology.restapp")
public class MyControllerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    protected ResponseEntity<String> resolveException(InvalidCredentials exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    protected ResponseEntity<String> resolveException(UnauthorizedUser exception) {
        System.out.println(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<String> resolveException(MissingServletRequestParameterException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
