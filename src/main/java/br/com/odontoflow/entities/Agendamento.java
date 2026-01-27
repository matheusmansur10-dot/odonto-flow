package br.com.odontoflow.entities;


import br.com.odontoflow.enums.StatusAgendamento;
import br.com.odontoflow.enums.TipoUsuario;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(
    name = "agendamento",
    indexes = {
        @Index(
            name = "idx_agendamento_dentista_data_hora",
            columnList = "dentista_id, data, hora_inicio"
        )
    }
)
public class Agendamento {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinica_id", nullable = false)
    private Clinica clinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentista_id", nullable = false)
    private Colaborador dentista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFim;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status = StatusAgendamento.AGENDADO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario criadoPor;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // getters e setters
}
