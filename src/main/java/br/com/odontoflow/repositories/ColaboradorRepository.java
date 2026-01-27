package br.com.odontoflow.repositories;

import br.com.odontoflow.entities.Colaborador;
import br.com.odontoflow.enums.PerfilColaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ColaboradorRepository extends JpaRepository<Colaborador, UUID> {

    List<Colaborador> findByClinicaIdAndPerfil(UUID clinicaId, PerfilColaborador perfil);
}
