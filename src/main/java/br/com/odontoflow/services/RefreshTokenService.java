package br.com.odontoflow.services;

import br.com.odontoflow.configurations.JwtTokenProvider;
import br.com.odontoflow.dtos.RefreshTokenResponseDTO;
import br.com.odontoflow.entities.RefreshToken;
import br.com.odontoflow.excepitions.RegraNegocioException;
import br.com.odontoflow.repositories.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository repository;
    private final JwtTokenProvider jwtProvider;

    public RefreshTokenService(
            RefreshTokenRepository repository,
            JwtTokenProvider jwtProvider) {
        this.repository = repository;
        this.jwtProvider = jwtProvider;
    }

    public RefreshTokenResponseDTO refresh(String token) {

        RefreshToken refreshToken = repository.findByToken(token)
            .orElseThrow(() -> new RegraNegocioException("Refresh token inválido"));

        if (refreshToken.getExpiracao().isBefore(LocalDateTime.now())) {
            throw new RegraNegocioException("Refresh token expirado");
        }

        String novoJwt = jwtProvider.gerarToken(
            refreshToken.getUsuario().getEmail(),
            Map.of("usuarioId", refreshToken.getUsuario().getId())
        );

        RefreshTokenResponseDTO response = new RefreshTokenResponseDTO();
        response.setAccessToken(novoJwt);
        return response;
    }
}
