package br.com.odontoflow.repositories;

import br.com.odontoflow.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {

    boolean existsByDentistaIdAndDataAndHoraInicio(
        UUID dentistaId,
        LocalDate data,
        LocalTime horaInicio
    );
}
