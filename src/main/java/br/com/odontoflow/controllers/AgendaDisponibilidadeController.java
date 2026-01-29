package br.com.odontoflow.controllers;

import br.com.odontoflow.dtos.DisponibilidadeRequestDTO;
import br.com.odontoflow.entities.AgendaDisponibilidade;
import br.com.odontoflow.services.AgendaDisponibilidadeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/dentistas/{dentistaId}/disponibilidades")
public class AgendaDisponibilidadeController {

    private final AgendaDisponibilidadeService service;

    public AgendaDisponibilidadeController(AgendaDisponibilidadeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendaDisponibilidade criar(
            @PathVariable UUID dentistaId,
            @RequestBody @Valid DisponibilidadeRequestDTO dto) {

        AgendaDisponibilidade disponibilidade = new AgendaDisponibilidade();
        disponibilidade.setData(dto.getData());
        disponibilidade.setHoraInicio(dto.getHoraInicio());
        disponibilidade.setHoraFim(dto.getHoraFim());

        return service.criarDisponibilidade(dentistaId, disponibilidade);
    }
}
