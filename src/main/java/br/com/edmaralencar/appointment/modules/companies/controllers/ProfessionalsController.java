package br.com.edmaralencar.appointment.modules.companies.controllers;

import br.com.edmaralencar.appointment.exceptions.EntityNotFoundException;
import br.com.edmaralencar.appointment.modules.companies.dtos.CreateProfessionalScheduleDTO;
import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import br.com.edmaralencar.appointment.modules.companies.entities.Professional;
import br.com.edmaralencar.appointment.modules.companies.repositories.CompaniesRepository;
import br.com.edmaralencar.appointment.modules.companies.repositories.ProfessionalsRepository;
import br.com.edmaralencar.appointment.modules.companies.useCases.CreateProfessionalScheduleUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/professionals")
public class ProfessionalsController {
    @Autowired
    private CreateProfessionalScheduleUseCase createProfessionalScheduleUseCase;

    @Autowired
    private ProfessionalsRepository professionalsRepository;

    @Autowired
    private CompaniesRepository companiesRepository;

    @PostMapping
    public ResponseEntity<List<Professional>> createProfessional(@Valid @RequestBody List<CreateProfessionalScheduleDTO> createProfessionalScheduleDTO) {
        List<Professional> professionals = createProfessionalScheduleUseCase.execute(createProfessionalScheduleDTO.get(0).getUserId(), createProfessionalScheduleDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(professionals);
    }

    @GetMapping("/{companyId}")
    @ResponseBody
    public ResponseEntity<List<Professional>> getProfessionalsByCompanyId(@PathVariable UUID companyId) {
        System.out.println(companyId);
        Company company = this.companiesRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não existe"));

        List<Professional> professionals = professionalsRepository.findManyByCompany(company);

        return ResponseEntity.status(HttpStatus.OK).body(professionals);
    }
}
