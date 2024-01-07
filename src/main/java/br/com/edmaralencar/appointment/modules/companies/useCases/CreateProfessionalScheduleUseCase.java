package br.com.edmaralencar.appointment.modules.companies.useCases;

import br.com.edmaralencar.appointment.exceptions.EntityNotFoundException;
import br.com.edmaralencar.appointment.modules.companies.dtos.CreateProfessionalScheduleDTO;
import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import br.com.edmaralencar.appointment.modules.companies.entities.Professional;
import br.com.edmaralencar.appointment.modules.companies.entities.Schedule;
import br.com.edmaralencar.appointment.modules.companies.repositories.CompaniesRepository;
import br.com.edmaralencar.appointment.modules.companies.repositories.ProfessionalsRepository;
import br.com.edmaralencar.appointment.modules.companies.repositories.SchedulesRepository;
import br.com.edmaralencar.appointment.modules.users.entities.User;
import br.com.edmaralencar.appointment.modules.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CreateProfessionalScheduleUseCase {
    @Autowired
    private ProfessionalsRepository professionalsRepository;

    @Autowired
    private CompaniesRepository companiesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private SchedulesRepository schedulesRepository;

    public List<Professional> execute(UUID userId, List<CreateProfessionalScheduleDTO> professionalScheduleDto) {
        User user = this.usersRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não existe"));

        Company company = this.companiesRepository.findByUser(user)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não existe"));

        List<Professional> professionals = new ArrayList<>();

        for (CreateProfessionalScheduleDTO professional : professionalScheduleDto) {
            Professional createdProfessional = new Professional();

            createdProfessional.setName(professional.getName());
            createdProfessional.setEmail(professional.getEmail());
            createdProfessional.setCompany(company);

            List<String> days = List.of(professional.getDays().split(","));
            List<String> hours = List.of(professional.getHours().split(","));

            professionals.add(createdProfessional);
            professionalsRepository.save(createdProfessional);

            System.out.println("ID: " + createdProfessional.getId());

            List<Schedule> combinations = generateCombinations(days, hours, createdProfessional);
            schedulesRepository.saveAll(combinations);
        }

        return professionals;
    }

    private static List<Schedule> generateCombinations(List<String> days, List<String> hours, Professional professional) {
        List<Schedule> combinations = new ArrayList<>();

        for (String day : days) {
            for (String hour : hours) {
                Schedule schedule = new Schedule();
                schedule.setDate(day);
                schedule.setHourOfDay(hour);
                schedule.setProfessionalId(professional.getId());
                combinations.add(schedule);
            }
        }

        return combinations;
    }
}
