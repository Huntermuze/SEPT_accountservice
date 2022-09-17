package com.septgroup.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class, AlreadyExistException.class, InvalidIdException.class})
    public ResponseEntity<Object> handleGenericClientException(NotFoundException e) {
        ApiExceptionDTO apiExceptionDTO = new ApiExceptionDTO(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return ResponseEntity.badRequest().body(apiExceptionDTO);
    }
}
