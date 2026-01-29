package br.com.odontoflow.dtos;

import java.math.BigDecimal;

public class FinanceiroRequestDTO {

    private BigDecimal valor;
    private String formaPagamento;

    // getters e setters

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
