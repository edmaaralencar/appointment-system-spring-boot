package br.com.edmaralencar.appointment.modules.companies.repositories;

import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import br.com.edmaralencar.appointment.modules.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompaniesRepository extends JpaRepository<Company, UUID> {
    Optional<Company> findByUser(User user);
}
