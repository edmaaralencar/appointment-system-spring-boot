package br.com.edmaralencar.appointment.modules.users.useCases;

import br.com.edmaralencar.appointment.modules.users.entities.User;
import br.com.edmaralencar.appointment.modules.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchUsersUseCase {
    @Autowired
    private UsersRepository usersRepository;

    public List<User> execute() {
        return this.usersRepository.findAll();
    }
}
