package br.com.odontoflow.repositories;

import br.com.odontoflow.entities.Agendamento;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

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


