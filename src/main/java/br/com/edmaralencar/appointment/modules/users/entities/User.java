package br.com.edmaralencar.appointment.modules.users.entities;

import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String type;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = true)
    private Company company;

    @JsonManagedReference
    public Company getCompany() {
        return company;
    }
}
