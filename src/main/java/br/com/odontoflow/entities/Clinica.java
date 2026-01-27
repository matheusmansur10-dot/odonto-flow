package br.com.odontoflow.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "clinica")
public class Clinica {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 150)
    private String nome;

    private String cnpj;
    private String telefone;
    private String email;

    private Boolean ativo = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // getters e setters
}
