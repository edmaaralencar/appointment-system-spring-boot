package br.com.edmaralencar.appointment.modules.companies.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "professionals")
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private Company company;

    @OneToMany(mappedBy = "professional", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Schedule> schedules;
}