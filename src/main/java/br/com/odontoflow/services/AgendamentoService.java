package br.com.odontoflow.services;

import br.com.odontoflow.entities.Agendamento;
import br.com.odontoflow.enums.PerfilColaborador;
import br.com.odontoflow.enums.StatusAgendamento;
import br.com.odontoflow.enums.TipoUsuario;
import br.com.odontoflow.excepitions.RegraNegocioException;
import br.com.odontoflow.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final AgendaDisponibilidadeRepository disponibilidadeRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final ClienteRepository clienteRepository;
    private final ClinicaRepository clinicaRepository;

    public AgendamentoService(
            AgendamentoRepository agendamentoRepository,
            AgendaDisponibilidadeRepository disponibilidadeRepository,
            ColaboradorRepository colaboradorRepository,
            ClienteRepository clienteRepository,
            ClinicaRepository clinicaRepository) {

        this.agendamentoRepository = agendamentoRepository;
        this.disponibilidadeRepository = disponibilidadeRepository;
        this.colaboradorRepository = colaboradorRepository;
        this.clienteRepository = clienteRepository;
        this.clinicaRepository = clinicaRepository;
    }

    @Transactional
    public Agendamento agendar(
            UUID clinicaId,
            UUID dentistaId,
            UUID clienteId,
            Agendamento agendamento,
            TipoUsuario criadoPor) {

        var clinica = clinicaRepository.findById(clinicaId)
                .orElseThrow(() -> new RegraNegocioException("Clínica não encontrada"));

        var dentista = colaboradorRepository.findById(dentistaId)
                .orElseThrow(() -> new RegraNegocioException("Dentista não encontrado"));

        if (dentista.getPerfil() != PerfilColaborador.DENTISTA) {
            throw new RegraNegocioException("Colaborador não é dentista");
        }

        var cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RegraNegocioException("Cliente não encontrado"));

        boolean conflito = agendamentoRepository.existsByDentistaIdAndDataAndHoraInicio(
                dentistaId,
                agendamento.getData(),
                agendamento.getHoraInicio()
        );

        if (conflito) {
            throw new RegraNegocioException("Horário indisponível");
        }

        boolean dentroDisponibilidade = disponibilidadeRepository
                .findByDentistaIdAndDataAndAtivoTrue(dentistaId, agendamento.getData())
                .stream()
                .anyMatch(d ->
                        !agendamento.getHoraInicio().isBefore(d.getHoraInicio()) &&
                        !agendamento.getHoraFim().isAfter(d.getHoraFim())
                );

        if (!dentroDisponibilidade) {
            throw new RegraNegocioException("Horário fora da disponibilidade do dentista");
        }

        agendamento.setClinica(clinica);
        agendamento.setDentista(dentista);
        agendamento.setCliente(cliente);
        agendamento.setStatus(StatusAgendamento.AGENDADO);
        agendamento.setCriadoPor(criadoPor);

        return agendamentoRepository.save(agendamento);
    }
}
