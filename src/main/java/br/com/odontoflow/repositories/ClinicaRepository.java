package br.com.odontoflow.repositories;

import br.com.odontoflow.entities.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicaRepository extends JpaRepository<Clinica, UUID> {
}
