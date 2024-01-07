package br.com.edmaralencar.appointment.modules.users.useCases;

import br.com.edmaralencar.appointment.exceptions.EntityAlreadyExistsException;
import br.com.edmaralencar.appointment.modules.users.entities.User;
import br.com.edmaralencar.appointment.modules.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserUseCase {
    @Autowired
    private UsersRepository usersRepository;

    public User execute(User user) {
        this.usersRepository.findByEmail(user.getEmail()).orElseThrow(() -> new EntityAlreadyExistsException("Usuário já existe"));

        User createdUser = new User();
        createdUser.setFirstName(user.getFirstName());
        createdUser.setLastName(user.getLastName());
        createdUser.setPassword(user.getPassword());
        createdUser.setType(user.getType());
        createdUser.setEmail(user.getEmail());

        usersRepository.save(createdUser);

        return createdUser;

    }
}
