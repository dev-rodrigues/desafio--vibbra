package com.vibbra.datasources.controlleradvice;

import com.vibbra.entities.Error;
import com.vibbra.exceptions.DealNotLocalizedException;
import com.vibbra.exceptions.MessageNotLocalizedException;
import com.vibbra.exceptions.UserNotAuthorizedException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error noResult(FeignException e) {
        return new Error("Invalid parameter");
    }

    @ResponseBody
    @ExceptionHandler(DealNotLocalizedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error badRequest(DealNotLocalizedException e) {
        return new Error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MessageNotLocalizedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error badRequest(MessageNotLocalizedException e) {
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


    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error notAuthorized(NullPointerException e) {
        return new Error("INTERNAL SERVER ERROR");
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error notAuthorized(RuntimeException e) {
        return new Error("error making http call");
    }



    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error notAuthorized(HttpRequestMethodNotSupportedException e) {
        return new Error("request method 'GET' not supported");
    }

}
