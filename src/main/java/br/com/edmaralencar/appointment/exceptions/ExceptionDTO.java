package br.com.edmaralencar.appointment.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionDTO {
    private String message;
    private HttpStatus httpStatus;
}
