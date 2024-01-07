package br.com.edmaralencar.appointment.modules.users.useCases;

import br.com.edmaralencar.appointment.exceptions.EntityAlreadyExistsException;
import br.com.edmaralencar.appointment.exceptions.EntityNotFoundException;
import br.com.edmaralencar.appointment.modules.categories.entities.Category;
import br.com.edmaralencar.appointment.modules.categories.repositories.CategoriesRepository;
import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import br.com.edmaralencar.appointment.modules.users.dtos.CreateProviderDTO;
import br.com.edmaralencar.appointment.modules.users.entities.User;
import br.com.edmaralencar.appointment.modules.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterProviderUseCase {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    public User execute(CreateProviderDTO user) {
        this.usersRepository.findByEmail(user.getEmail()).orElseThrow(() -> new EntityAlreadyExistsException("Usuário já existe"));

        User createdUser = new User();
        createdUser.setFirstName(user.getFirstName());
        createdUser.setLastName(user.getLastName());
        createdUser.setPassword(user.getPassword());
        createdUser.setType(user.getType());
        createdUser.setEmail(user.getEmail());

        Category category = this.categoriesRepository.findById(user.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não existe"));

        Company company = new Company();
        company.setCategory(category);

        createdUser.setCompany(company);

        usersRepository.save(createdUser);

        return createdUser;

    }
}
