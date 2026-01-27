package br.com.odontoflow.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_id", nullable = false, unique = true)
    private Agendamento agendamento;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(columnDefinition = "TEXT")
    private String procedimentos;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // getters e setters
}
