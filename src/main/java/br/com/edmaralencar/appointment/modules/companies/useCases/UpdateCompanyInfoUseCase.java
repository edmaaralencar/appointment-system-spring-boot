package br.com.edmaralencar.appointment.modules.companies.useCases;

import br.com.edmaralencar.appointment.exceptions.EntityNotFoundException;
import br.com.edmaralencar.appointment.modules.companies.dtos.UpdateCompanyDTO;
import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import br.com.edmaralencar.appointment.modules.companies.exceptions.TypeNotAllowedException;
import br.com.edmaralencar.appointment.modules.companies.repositories.CompaniesRepository;
import br.com.edmaralencar.appointment.modules.users.entities.User;
import br.com.edmaralencar.appointment.modules.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCompanyInfoUseCase {
    @Autowired
    private CompaniesRepository companiesRepository;

    @Autowired
    private UsersRepository usersRepository;

    public Company execute(UUID userId, UpdateCompanyDTO updateCompanyDTO) {
        User user = this.usersRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não existe"));

        if (user.getType().equals("CLI")) {
            throw new TypeNotAllowedException();
        }

        Company company = this.companiesRepository.findByUser(user)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não existe"));

        company.setStreet(updateCompanyDTO.getStreet());
        company.setCity(updateCompanyDTO.getCity());
        company.setDocument(updateCompanyDTO.getDocument());

        this.companiesRepository.save(company);

        return company;
    }
}
