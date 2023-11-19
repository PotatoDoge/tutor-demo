package com.bfp.tutordemo.response;

import com.bfp.tutordemo.response.exception.NotFoundInDatabase;
import com.bfp.tutordemo.response.exception.ValueExistsInDatabase;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.now;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponse handleValidationException(MethodArgumentNotValidException ex) {

        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(400)
                .status(HttpStatus.BAD_REQUEST)
                .message("Validation failed")
                .data(validationErrors)
                .build();
    }

    @ExceptionHandler(ValueExistsInDatabase.class)
    @ResponseStatus(HttpStatus.OK)
    public HttpResponse handleExistingValuesInDatabase(ValueExistsInDatabase ex) {
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(200)
                .status(HttpStatus.OK)
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(NotFoundInDatabase.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpResponse handleNotFoundInDatabase(NotFoundInDatabase ex) {
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(404)
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public HttpResponse handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        if (ex.getCause() != null) {
            // Handle SQLIntegrityConstraintViolationException here
            return HttpResponse.builder()
                    .timestamp(now().toString())
                    .statusCode(400)
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Duplicate entry or constraint violation occurred.")
                    .build();
        }

        // Handle other DataIntegrityViolationExceptions if needed
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(500)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("Data integrity violation occurred.")
                .build();
    }

}
