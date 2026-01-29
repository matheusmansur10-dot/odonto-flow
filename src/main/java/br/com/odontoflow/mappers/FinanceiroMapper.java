package br.com.odontoflow.mappers;

import br.com.odontoflow.dtos.FinanceiroRequestDTO;
import br.com.odontoflow.entities.Financeiro;
import br.com.odontoflow.enums.FormaPagamento;

public class FinanceiroMapper {

    public static Financeiro toEntity(FinanceiroRequestDTO dto) {
        Financeiro financeiro = new Financeiro();
        financeiro.setValor(dto.getValor());
        financeiro.setFormaPagamento(FormaPagamento.valueOf(dto.getFormaPagamento()));
        return financeiro;
    }
}
