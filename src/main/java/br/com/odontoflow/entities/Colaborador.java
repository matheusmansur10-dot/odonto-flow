package br.com.odontoflow.entities;


import br.com.odontoflow.enums.PerfilColaborador;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "colaborador")
public class Colaborador {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinica_id", nullable = false)
    private Clinica clinica;

    @Column(nullable = false, length = 150)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PerfilColaborador perfil;

    private String registroProfissional;

    private Boolean ativo = true;

    public boolean getPerfil() {
    }

    // getters e setters
}
