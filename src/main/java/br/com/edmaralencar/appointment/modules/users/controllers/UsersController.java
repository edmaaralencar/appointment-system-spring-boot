package br.com.edmaralencar.appointment.modules.users.controllers;

import br.com.edmaralencar.appointment.exceptions.EntityNotFoundException;
import br.com.edmaralencar.appointment.modules.categories.entities.Category;
import br.com.edmaralencar.appointment.modules.categories.repositories.CategoriesRepository;
import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import br.com.edmaralencar.appointment.modules.users.dtos.CreateProviderDTO;
import br.com.edmaralencar.appointment.modules.users.entities.User;
import br.com.edmaralencar.appointment.modules.users.repositories.UsersRepository;
import br.com.edmaralencar.appointment.modules.users.useCases.FetchUsersUseCase;
import br.com.edmaralencar.appointment.modules.users.useCases.RegisterProviderUseCase;
import br.com.edmaralencar.appointment.modules.users.useCases.RegisterUserUseCase;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private FetchUsersUseCase fetchUsersUseCase;

    @Autowired
    private RegisterUserUseCase registerUserUseCase;

    @Autowired
    private RegisterProviderUseCase registerProviderUseCase;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping
    public ResponseEntity<List<User>> listAll() {
        List<User> users = fetchUsersUseCase.execute();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = registerUserUseCase.execute(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/provider")
    public ResponseEntity<User> createProvider(@Valid @RequestBody CreateProviderDTO user) {
        User createdUser = registerProviderUseCase.execute(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
