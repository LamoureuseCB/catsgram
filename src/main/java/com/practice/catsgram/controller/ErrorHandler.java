package com.practice.catsgram.controller;

import com.practice.catsgram.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse emailHandle(final InvalidEmailException e){
        return new ErrorResponse("Ошибка! Неверный почтовый адрес email", e.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse emailHandle(final PostNotFoundException e){
        return new ErrorResponse("Ошибка! Пост не найден", e.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userHandle(final UserNotFoundException e){
        return new ErrorResponse("Ошибка! Пользователь не найден", e.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse userExistHandle(final UserAlreadyExistException e){
        return new ErrorResponse("Ошибка! Пользователь уже создан", e.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse incorrectParameterHandle(final IncorrectParameterException e){
        return new ErrorResponse("Ошибка! ", e.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse incorrectParameterHandle(final Throwable e){
        return new ErrorResponse("Произошла непредвиденная ошибка.", e.getMessage());
    }


}
