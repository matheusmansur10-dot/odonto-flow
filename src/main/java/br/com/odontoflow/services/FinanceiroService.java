package br.com.odontoflow.services;

import br.com.odontoflow.entities.Atendimento;
import br.com.odontoflow.entities.Financeiro;
import br.com.odontoflow.excepitions.RegraNegocioException;
import br.com.odontoflow.repositories.AtendimentoRepository;
import br.com.odontoflow.repositories.FinanceiroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FinanceiroService {

    private final FinanceiroRepository financeiroRepository;
    private final AtendimentoRepository atendimentoRepository;

    public FinanceiroService(
            FinanceiroRepository financeiroRepository,
            AtendimentoRepository atendimentoRepository) {
        this.financeiroRepository = financeiroRepository;
        this.atendimentoRepository = atendimentoRepository;
    }

    public Financeiro gerarFinanceiro(UUID atendimentoId, Financeiro financeiro) {

        Atendimento atendimento = atendimentoRepository.findById(atendimentoId)
                .orElseThrow(() -> new RegraNegocioException("Atendimento não encontrado"));

        financeiro.setAtendimento(atendimento);
        return financeiroRepository.save(financeiro);
    }

    public Financeiro registrarPagamento(UUID financeiroId) {

        Financeiro financeiro = financeiroRepository.findById(financeiroId)
                .orElseThrow(() -> new RegraNegocioException("Registro financeiro não encontrado"));

        financeiro.setPago(true);
        financeiro.setDataPagamento(LocalDateTime.now());

        return financeiroRepository.save(financeiro);
    }
}
