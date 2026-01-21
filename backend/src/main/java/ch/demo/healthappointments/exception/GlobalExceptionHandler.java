package ch.demo.healthappointments.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity<String>> handleBadRequest(IllegalArgumentException ex) {
        return Mono.just(ResponseEntity.badRequest().body(ex.getMessage()));
    }
}
