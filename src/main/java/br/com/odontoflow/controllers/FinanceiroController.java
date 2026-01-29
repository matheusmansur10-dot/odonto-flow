package br.com.odontoflow.controllers;

import br.com.odontoflow.dtos.FinanceiroRequestDTO;
import br.com.odontoflow.entities.Financeiro;
import br.com.odontoflow.mappers.FinanceiroMapper;
import br.com.odontoflow.services.FinanceiroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    private final FinanceiroService service;

    public FinanceiroController(FinanceiroService service) {
        this.service = service;
    }

    @PostMapping("/atendimentos/{atendimentoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Financeiro gerar(
            @PathVariable UUID atendimentoId,
            @RequestBody @Valid FinanceiroRequestDTO dto) {

        Financeiro financeiro = FinanceiroMapper.toEntity(dto);
        return service.gerarFinanceiro(atendimentoId, financeiro);
    }

    @PostMapping("/{financeiroId}/pagar")
    public Financeiro pagar(@PathVariable UUID financeiroId) {
        return service.registrarPagamento(financeiroId);
    }
}
