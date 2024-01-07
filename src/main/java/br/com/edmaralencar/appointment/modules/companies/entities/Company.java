package br.com.edmaralencar.appointment.modules.companies.entities;

import br.com.edmaralencar.appointment.modules.categories.entities.Category;
import br.com.edmaralencar.appointment.modules.users.entities.User;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Category category;

    private String street;
    private String city;
    private String document;

    @OneToOne(mappedBy = "company")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    private List<Professional> professionals;

    @JsonBackReference
    public User getUser() {
        return this.user;
    }
}