package br.com.odontoflow.services;

import br.com.odontoflow.entities.Agendamento;
import br.com.odontoflow.entities.Atendimento;
import br.com.odontoflow.enums.StatusAgendamento;
import br.com.odontoflow.excepitions.RegraNegocioException;
import br.com.odontoflow.repositories.AgendamentoRepository;
import br.com.odontoflow.repositories.AtendimentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final AgendamentoRepository agendamentoRepository;

    public AtendimentoService(
            AtendimentoRepository atendimentoRepository,
            AgendamentoRepository agendamentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    @Transactional
    public Atendimento realizarAtendimento(UUID agendamentoId, Atendimento atendimento) {

        Agendamento agendamento = agendamentoRepository.findById(agendamentoId)
                .orElseThrow(() -> new RegraNegocioException("Agendamento não encontrado"));

        if (agendamento.getStatus() != StatusAgendamento.AGENDADO) {
            throw new RegraNegocioException("Agendamento não pode ser atendido");
        }

        agendamento.setStatus(StatusAgendamento.ATENDIDO);

        atendimento.setAgendamento(agendamento);
        return atendimentoRepository.save(atendimento);
    }
}
