package br.com.odontoflow.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Column(nullable = false, length = 150)
    private String nome;

    private String cpf;
    private String telefone;

    private LocalDate dataNascimento;

    // getters e setters
}
