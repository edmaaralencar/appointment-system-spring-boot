package br.com.edmaralencar.appointment.modules.companies.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateCompanyDTO {
    private String street;
    private String city;
    private String document;
    private UUID userId;
}
