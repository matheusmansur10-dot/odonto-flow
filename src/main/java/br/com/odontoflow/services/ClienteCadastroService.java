package br.com.odontoflow.services;

import br.com.odontoflow.dtos.ClienteCadastroDTO;
import br.com.odontoflow.entities.Cliente;
import br.com.odontoflow.entities.Usuario;
import br.com.odontoflow.enums.TipoUsuario;
import br.com.odontoflow.excepitions.RegraNegocioException;
import br.com.odontoflow.repositories.ClienteRepository;
import br.com.odontoflow.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteCadastroService {

    private final UsuarioRepository usuarioRepo;
    private final ClienteRepository clienteRepo;
    private final PasswordEncoder encoder;

    public ClienteCadastroService(UsuarioRepository usuarioRepo, ClienteRepository clienteRepo, PasswordEncoder encoder) {
        this.usuarioRepo = usuarioRepo;
        this.clienteRepo = clienteRepo;
        this.encoder = encoder;
    }

    public Cliente cadastrar(ClienteCadastroDTO dto) {

        if (usuarioRepo.findByEmail(dto.getEmail()).isPresent()) {
            throw new RegraNegocioException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setSenhaHash(encoder.encode(dto.getSenha()));
        usuario.setTipoUsuario(TipoUsuario.CLIENTE);

        usuarioRepo.save(usuario);

        Cliente cliente = new Cliente();
        cliente.setUsuario(usuario);
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());

        return clienteRepo.save(cliente);
    }
}
