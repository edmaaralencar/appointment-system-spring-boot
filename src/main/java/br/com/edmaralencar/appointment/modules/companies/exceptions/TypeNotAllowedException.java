package br.com.edmaralencar.appointment.modules.companies.exceptions;

public class TypeNotAllowedException extends RuntimeException {
    public TypeNotAllowedException() {
        super("Clientes não tem acesso");
    }
}
