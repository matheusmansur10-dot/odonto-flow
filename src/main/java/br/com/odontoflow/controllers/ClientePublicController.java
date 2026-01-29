package br.com.odontoflow.controllers;

import br.com.odontoflow.dtos.ClienteCadastroDTO;
import br.com.odontoflow.services.ClienteCadastroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/clientes")
public class ClientePublicController {

    private final ClienteCadastroService service;

    public ClientePublicController(ClienteCadastroService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody @Valid ClienteCadastroDTO dto) {
        service.cadastrar(dto);
    }
}
