package br.com.tokiomarine.seguradora.avaliacao.service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

import javax.validation.Valid;
import java.util.List;

public interface EstudandeService {

    List<Estudante> buscarEstudantes();

    void cadastrarEstudante(@Valid Estudante estudante);

    Estudante buscarEstudante(long id);

    void atualizarEstudante(@Valid Estudante estudante);

    Boolean apagarEstudante(Long id);
}
