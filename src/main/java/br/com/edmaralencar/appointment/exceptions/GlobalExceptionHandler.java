package br.com.edmaralencar.appointment.exceptions;

import br.com.edmaralencar.appointment.modules.companies.exceptions.TypeNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ExceptionDTO> handleEntityNotFound(EntityNotFoundException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage(), HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    private ResponseEntity<ExceptionDTO> handleEntityAlreadyExists(EntityAlreadyExistsException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage(), HttpStatus.CONFLICT);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
    }

    @ExceptionHandler(TypeNotAllowedException.class)
    private ResponseEntity<ExceptionDTO> handleUserTypeNotAllowed(TypeNotAllowedException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage(), HttpStatus.FORBIDDEN);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
    }
}
