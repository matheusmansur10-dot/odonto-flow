package br.com.odontoflow.repositories;

import br.com.odontoflow.entities.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AtendimentoRepository extends JpaRepository<Atendimento, UUID> {
}
