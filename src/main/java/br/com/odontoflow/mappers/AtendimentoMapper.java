package br.com.odontoflow.mappers;

import br.com.odontoflow.dtos.AtendimentoRequestDTO;
import br.com.odontoflow.entities.Atendimento;

public class AtendimentoMapper {

    public static Atendimento toEntity(AtendimentoRequestDTO dto) {
        Atendimento atendimento = new Atendimento();
        atendimento.setObservacoes(dto.getObservacoes());
        atendimento.setProcedimentos(dto.getProcedimentos());
        return atendimento;
    }
}
