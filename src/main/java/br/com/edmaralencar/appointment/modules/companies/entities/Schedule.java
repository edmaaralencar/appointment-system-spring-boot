package br.com.edmaralencar.appointment.modules.companies.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "professional_schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String date;
    private String hourOfDay;

    @ManyToOne
    @JoinColumn(name = "professional_id", insertable = false, updatable = false)
    @JsonBackReference
    private Professional professional;

    @Column(name = "professional_id")
    private UUID professionalId;
}