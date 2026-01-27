package br.com.odontoflow.entities;

import br.com.odontoflow.enums.TipoUsuario;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String senhaHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;

    private Boolean ativo = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // getters e setters
}
