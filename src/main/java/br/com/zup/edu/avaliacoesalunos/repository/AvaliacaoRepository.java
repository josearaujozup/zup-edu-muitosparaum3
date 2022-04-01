package br.com.zup.edu.avaliacoesalunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.avaliacoesalunos.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

}
