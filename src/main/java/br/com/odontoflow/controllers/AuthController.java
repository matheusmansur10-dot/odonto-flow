package br.com.odontoflow.controllers;

import br.com.odontoflow.dtos.LoginRequestDTO;
import br.com.odontoflow.dtos.LoginResponseDTO;
import br.com.odontoflow.dtos.RefreshTokenRequestDTO;
import br.com.odontoflow.dtos.RefreshTokenResponseDTO;
import br.com.odontoflow.services.AuthService;
import br.com.odontoflow.services.RefreshTokenService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    public AuthController(AuthService authService, RefreshTokenService refreshTokenService) {
        this.authService = authService;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody @Valid LoginRequestDTO dto) {
        return authService.login(dto);
    }

    @PostMapping("/refresh")
    public RefreshTokenResponseDTO refresh(
            @RequestBody RefreshTokenRequestDTO dto) {
        return refreshTokenService.refresh(dto.getRefreshToken());
    }

}
