package br.com.tokiomarine.seguradora.avaliacao.repository;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
