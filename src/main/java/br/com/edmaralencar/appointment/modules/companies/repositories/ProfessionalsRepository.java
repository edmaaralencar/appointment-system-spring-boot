package br.com.edmaralencar.appointment.modules.companies.repositories;

import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import br.com.edmaralencar.appointment.modules.companies.entities.Professional;
import br.com.edmaralencar.appointment.modules.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfessionalsRepository extends JpaRepository<Professional, UUID> {
    Optional<Professional> findByCompany(Company company);
    List<Professional> findManyByCompany(Company company);
}
