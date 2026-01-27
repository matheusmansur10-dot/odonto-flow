package br.com.odontoflow.services;

import br.com.odontoflow.entities.AgendaDisponibilidade;
import br.com.odontoflow.entities.Colaborador;
import br.com.odontoflow.enums.PerfilColaborador;
import br.com.odontoflow.excepitions.RegraNegocioException;
import br.com.odontoflow.repositories.AgendaDisponibilidadeRepository;
import br.com.odontoflow.repositories.ColaboradorRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AgendaDisponibilidadeService {

    private final AgendaDisponibilidadeRepository repository;
    private final ColaboradorRepository colaboradorRepository;

    public AgendaDisponibilidadeService(
            AgendaDisponibilidadeRepository repository,
            ColaboradorRepository colaboradorRepository) {
        this.repository = repository;
        this.colaboradorRepository = colaboradorRepository;
    }

    public AgendaDisponibilidade criarDisponibilidade(
            UUID dentistaId,
            AgendaDisponibilidade disponibilidade) {

        Colaborador dentista = colaboradorRepository.findById(dentistaId)
                .orElseThrow(() -> new RegraNegocioException("Dentista não encontrado"));

        if (dentista.getPerfil() != PerfilColaborador.DENTISTA) {
            throw new RegraNegocioException("Somente dentistas podem ter agenda");
        }

        disponibilidade.setDentista(dentista);
        return repository.save(disponibilidade);
    }
}
