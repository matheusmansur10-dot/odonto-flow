package br.com.odontoflow.repositories;

import br.com.odontoflow.entities.AgendaDisponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AgendaDisponibilidadeRepository extends JpaRepository<AgendaDisponibilidade, UUID> {

    List<AgendaDisponibilidade> findByDentistaIdAndDataAndAtivoTrue(
        UUID dentistaId,
        LocalDate data
    );
}
