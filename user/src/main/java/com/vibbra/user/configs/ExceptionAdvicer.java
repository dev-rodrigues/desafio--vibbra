package com.vibbra.user.configs;

import com.vibbra.user.datasources.h2.exceptions.UserNotFoundException;
import com.vibbra.user.datasources.keycloak.exceptions.UserOrPasswordDoesNotExists;
import com.vibbra.user.transportLayers.openapi.model.Error;
import feign.FeignException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionAdvicer {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error badRequest(UserNotFoundException e) {
        var error = new Error();
        error.setError(e.getMessage());
        return error;
    }

    @ResponseBody
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Error> feignHandler(FeignException e) {
        var error = new Error();
        error.setError(e.contentUTF8());
        return ResponseEntity.status(HttpStatus.valueOf(e.status())).body(error);
    }

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error feignHandler(DataIntegrityViolationException e) {
        var error = new Error();
        error.setError(e.getMessage());
        return error;
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error constraintValidationHandler(ConstraintViolationException e) {
        var error = new Error();
        error.setError(e.getMessage());
        return error;
    }

    @ResponseBody
    @ExceptionHandler(UserOrPasswordDoesNotExists.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error constraintValidationHandler(UserOrPasswordDoesNotExists e) {
        var error = new Error();
        error.setError(e.getMessage());
        return error;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error genericHandler(Exception e) {
        var error = new Error();
        error.setError(e.getMessage());
        return error;
    }
}
