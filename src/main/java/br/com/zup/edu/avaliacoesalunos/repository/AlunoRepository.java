package br.com.zup.edu.avaliacoesalunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.avaliacoesalunos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
