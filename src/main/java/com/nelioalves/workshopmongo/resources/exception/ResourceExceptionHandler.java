package com.nelioalves.workshopmongo.resources.exception;

import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice // Essa Anotação indica que essa clase ira tratar possiveis erros nas minha requisições
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) // essa anotation serve pra avisar o spring, se em qualquer lugar (Controller ou service) acontecer essa exception, com essa anotation a gente fala para o spring tratar com essa classe que montamos
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Not Found", e.getMessage(),  request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
