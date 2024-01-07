package br.com.edmaralencar.appointment.config;

import br.com.edmaralencar.appointment.modules.categories.entities.Category;
import br.com.edmaralencar.appointment.modules.categories.repositories.CategoriesRepository;
import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import br.com.edmaralencar.appointment.modules.users.entities.User;
import br.com.edmaralencar.appointment.modules.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedConfig implements ApplicationRunner {

    private final CategoriesRepository categoriesRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public SeedConfig(CategoriesRepository categoriesRepository, UsersRepository usersRepository) {
        this.categoriesRepository = categoriesRepository;
        this.usersRepository = usersRepository;
    }

    public void run(ApplicationArguments args) {
        Category category1 = new Category();
        category1.setName("Barbearia");
        category1.setImageUrl("");
        Category category2 = new Category();
        category2.setName("Medicina");
        category2.setImageUrl("");

        User user = new User();
        user.setEmail("cli@gmail.com");
        user.setType("CLI");
        user.setFirstName("CLI");
        user.setLastName("Edmar");
        user.setPassword("123456");

        User user1 = new User();
        user1.setEmail("pf@gmail.com");
        user1.setType("PF");
        user1.setFirstName("PF");
        user1.setLastName("Edmar");
        user1.setPassword("123456");
        Company company = new Company();
        company.setCategory(category1);
        user1.setCompany(company);

        categoriesRepository.save(category1);
        categoriesRepository.save(category2);

        usersRepository.save(user);
        usersRepository.save(user1);

        System.out.println("CATEGORIA 1: " + category1.getName() + " ID: " + category1.getId());
    }
}
