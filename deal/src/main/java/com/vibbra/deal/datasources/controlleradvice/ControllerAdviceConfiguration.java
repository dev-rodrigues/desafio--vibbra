package com.vibbra.deal.datasources.controlleradvice;

import com.vibbra.deal.entities.Error;
import com.vibbra.deal.expections.DealNotLocalizedException;
import com.vibbra.deal.expections.UserNotAuthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.NoResultException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdviceConfiguration {

    @ResponseBody
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error dealNotLocalizedException(NoResultException e) {
        return new Error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error methodArgument(MethodArgumentNotValidException e) {
        String messages = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
                .collect(Collectors.joining());
        return new Error(messages);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error noResult(MethodArgumentTypeMismatchException e) {
        return new Error("Invalid parameter");
    }

    @ResponseBody
    @ExceptionHandler(DealNotLocalizedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error badRequest(DealNotLocalizedException e) {
        return new Error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UserNotAuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Error notAuthorized(UserNotAuthorizedException e) {
        return new Error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error notAuthorized(MissingRequestHeaderException e) {
        return new Error(e.getMessage());
    }



}
