package br.com.odontoflow.entities;


import br.com.odontoflow.enums.FormaPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "financeiro")
public class Financeiro {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atendimento_id", nullable = false, unique = true)
    private Atendimento atendimento;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    private Boolean pago = false;

    private LocalDateTime dataPagamento;

    // getters e setters
}
