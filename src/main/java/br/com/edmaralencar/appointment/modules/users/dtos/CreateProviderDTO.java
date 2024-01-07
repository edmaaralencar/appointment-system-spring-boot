package br.com.edmaralencar.appointment.modules.users.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateProviderDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String type;
    private UUID categoryId;
}
