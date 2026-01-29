package br.com.odontoflow.controllers;

import br.com.odontoflow.dtos.AtendimentoRequestDTO;
import br.com.odontoflow.entities.Atendimento;
import br.com.odontoflow.mappers.AtendimentoMapper;
import br.com.odontoflow.services.AtendimentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/agendamentos/{agendamentoId}/atendimento")
public class AtendimentoController {

    private final AtendimentoService service;

    public AtendimentoController(AtendimentoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atendimento atender(
            @PathVariable UUID agendamentoId,
            @RequestBody @Valid AtendimentoRequestDTO dto) {

        Atendimento atendimento = AtendimentoMapper.toEntity(dto);
        return service.realizarAtendimento(agendamentoId, atendimento);
    }
}
