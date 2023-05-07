package ru.kotov.VacationCalculator.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidNumberFormatExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleException (InvalidNumberFormatException e) {
        CalculatorErrorResponse response = new CalculatorErrorResponse(
                400,
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
