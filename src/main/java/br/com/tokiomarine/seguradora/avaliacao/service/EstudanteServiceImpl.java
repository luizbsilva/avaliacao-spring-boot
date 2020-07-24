package br.com.tokiomarine.seguradora.avaliacao.service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudanteServiceImpl implements EstudandeService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Override
    public void cadastrarEstudante(@Valid Estudante estudante) {
        estudanteRepository.save(estudante);
    }

    @Override
    public void atualizarEstudante(@Valid Estudante estudante) {
        estudanteRepository.save(estudante);
    }

    @Override
    public List<Estudante> buscarEstudantes() {
        Iterable<Estudante> it = estudanteRepository.findAll();

        List<Estudante> estudantes = new ArrayList<>();

        for (Estudante e : it) {
            estudantes.add(e);
        }

        return estudantes;
    }

    @Override
    public Estudante buscarEstudante(long id) {
        if (id == 0) {
            throw new IllegalArgumentException("Identificador inválido:" + id);
        }

        if (estudanteRepository.findById(id).isPresent()) {
            return estudanteRepository.findById(id).get();
        }
        return null;
    }

    public Boolean apagarEstudante(Long id) {
        if (estudanteRepository.findById(id).isPresent()) {
            estudanteRepository.deleteById(id);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }
}
