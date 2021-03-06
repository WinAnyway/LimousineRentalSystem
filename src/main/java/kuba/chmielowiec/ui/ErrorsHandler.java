package kuba.chmielowiec.ui;

import kuba.chmielowiec.domain.commands.InvalidCommandException;
import kuba.chmielowiec.domain.commands.Validatable;
import kuba.chmielowiec.infrastructure.NoResourceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsHandler {

    @ExceptionHandler(InvalidCommandException.class)
    public ResponseEntity<Validatable.ValidationErrors> handleInvalidCommandException(InvalidCommandException e) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<>(e.getErrors(), headers, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoResourceException.class)
    public ResponseEntity<String> handleNoResourceException(NoResourceException e) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<>("{\"error\": \"" + e.getMessage() + "\"}", headers, HttpStatus.NOT_FOUND);
    }
}
