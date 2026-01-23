package ch.demo.healthappointments.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;


@RestControllerAdvice
public class GlobalExceptionHandler {

      @ExceptionHandler(BLLException.class)
    public ResponseEntity<String> handleBusinessException(BLLException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

     @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(
            WebExchangeBindException ex) {

        Map<String, Object> errors = new HashMap<>();

        ex.getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity
                .badRequest()
                .body(errors);
    }
}
