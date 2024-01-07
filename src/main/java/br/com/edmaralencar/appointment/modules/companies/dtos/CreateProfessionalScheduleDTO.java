package br.com.edmaralencar.appointment.modules.companies.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateProfessionalScheduleDTO {
    private String name;
    private String email;
    private UUID userId;
    private String days;
    private String hours;
    private Boolean workInHolidays;
}
