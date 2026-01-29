package br.com.odontoflow.services;

import br.com.odontoflow.configurations.JwtTokenProvider;
import br.com.odontoflow.dtos.LoginRequestDTO;
import br.com.odontoflow.dtos.LoginResponseDTO;
import br.com.odontoflow.repositories.ColaboradorRepository;
import br.com.odontoflow.repositories.UsuarioRepository;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    private final AuthenticationManager authManager;
    private final JwtTokenProvider tokenProvider;
    private final UsuarioRepository usuarioRepository;
    private final ColaboradorRepository colaboradorRepository;

    public AuthService(
            AuthenticationManager authManager,
            JwtTokenProvider tokenProvider,
            UsuarioRepository usuarioRepository,
            ColaboradorRepository colaboradorRepository) {
        this.authManager = authManager;
        this.tokenProvider = tokenProvider;
        this.usuarioRepository = usuarioRepository;
        this.colaboradorRepository = colaboradorRepository;
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getSenha()
                )
        );

        var usuario = usuarioRepository.findByEmail(dto.getEmail()).get();

        var claims = new HashMap<String, Object>();
        claims.put("usuarioId", usuario.getId());
        claims.put("tipoUsuario", usuario.getTipoUsuario().name());

        LoginResponseDTO response = new LoginResponseDTO();

        if (usuario.getTipoUsuario().name().equals("COLABORADOR")) {
            var colab = colaboradorRepository
                    .findById(usuario.getId())
                    .orElse(null);

            if (colab != null) {
                claims.put("clinicaId", colab.getClinica().getId());
                claims.put("perfil", colab.getPerfil().name());

                response.setClinicaId(colab.getClinica().getId());
                response.setPerfil(colab.getPerfil().name());
            }
        }

        String token = tokenProvider.gerarToken(usuario.getEmail(), claims);

        response.setToken(token);
        response.setUsuarioId(usuario.getId());
        response.setTipoUsuario(usuario.getTipoUsuario().name());

        return response;
    }
}
