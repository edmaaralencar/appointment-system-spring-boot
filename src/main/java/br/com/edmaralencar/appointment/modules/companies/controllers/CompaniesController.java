package br.com.edmaralencar.appointment.modules.companies.controllers;

import br.com.edmaralencar.appointment.modules.companies.dtos.UpdateCompanyDTO;
import br.com.edmaralencar.appointment.modules.companies.entities.Company;
import br.com.edmaralencar.appointment.modules.companies.repositories.CompaniesRepository;
import br.com.edmaralencar.appointment.modules.companies.useCases.UpdateCompanyInfoUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @Autowired
    private CompaniesRepository companiesRepository;

    @Autowired
    private UpdateCompanyInfoUseCase updateCompanyInfoUseCase;

    @PutMapping
    public ResponseEntity<Company> updateCompanyInfo(@Valid @RequestBody UpdateCompanyDTO updateCompanyDTO) {
        Company company = updateCompanyInfoUseCase.execute(updateCompanyDTO.getUserId(), updateCompanyDTO);

        return ResponseEntity.status(HttpStatus.OK).body(company);
    }
}


