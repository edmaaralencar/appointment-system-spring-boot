package br.com.edmaralencar.appointment.modules.companies.repositories;

import br.com.edmaralencar.appointment.modules.companies.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchedulesRepository extends JpaRepository<Schedule, UUID> { }
