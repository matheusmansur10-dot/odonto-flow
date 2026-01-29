package br.com.odontoflow.controllers;

import br.com.odontoflow.dtos.AgendamentoRequestDTO;
import br.com.odontoflow.dtos.AgendamentoResponseDTO;
import br.com.odontoflow.enums.TipoUsuario;
import br.com.odontoflow.mappers.AgendamentoMapper;
import br.com.odontoflow.services.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoResponseDTO agendar(
            @RequestBody @Valid AgendamentoRequestDTO dto) {

        var entity = AgendamentoMapper.toEntity(dto);

        var agendamento = service.agendar(
                dto.getClinicaId(),
                dto.getDentistaId(),
                dto.getClienteId(),
                entity,
                TipoUsuario.CLIENTE // depois vem do JWT
        );

        return AgendamentoMapper.toResponse(agendamento);
    }
}
