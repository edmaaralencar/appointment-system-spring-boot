package br.com.edmaralencar.appointment.modules.categories.entities;

import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String imageUrl;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Company> companies;
}
