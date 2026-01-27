package br.com.odontoflow.repositories;

import br.com.odontoflow.entities.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FinanceiroRepository extends JpaRepository<Financeiro, UUID> {

    Optional<Financeiro> findByAtendimentoId(UUID atendimentoId);
}
