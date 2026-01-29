package br.com.odontoflow.mappers;

import br.com.odontoflow.dtos.AgendamentoRequestDTO;
import br.com.odontoflow.dtos.AgendamentoResponseDTO;
import br.com.odontoflow.entities.Agendamento;

public class AgendamentoMapper {

    public static Agendamento toEntity(AgendamentoRequestDTO dto) {
        Agendamento agendamento = new Agendamento();
        agendamento.setData(dto.getData());
        agendamento.setHoraInicio(dto.getHoraInicio());
        agendamento.setHoraFim(dto.getHoraFim());
        return agendamento;
    }

    public static AgendamentoResponseDTO toResponse(Agendamento agendamento) {
        AgendamentoResponseDTO dto = new AgendamentoResponseDTO();
        dto.setId(agendamento.getId());
        dto.setClinicaId(agendamento.getClinica().getId());
        dto.setDentistaId(agendamento.getDentista().getId());
        dto.setClienteId(agendamento.getCliente().getId());
        dto.setData(agendamento.getData());
        dto.setHoraInicio(agendamento.getHoraInicio());
        dto.setHoraFim(agendamento.getHoraFim());
        dto.setStatus(agendamento.getStatus().name());
        return dto;
    }
}
