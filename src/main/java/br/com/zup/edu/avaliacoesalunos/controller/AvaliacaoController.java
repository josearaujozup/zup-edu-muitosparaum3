package br.com.zup.edu.avaliacoesalunos.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.avaliacoesalunos.model.Aluno;
import br.com.zup.edu.avaliacoesalunos.model.Avaliacao;
import br.com.zup.edu.avaliacoesalunos.repository.AlunoRepository;
import br.com.zup.edu.avaliacoesalunos.repository.AvaliacaoRepository;

@RestController
@RequestMapping("/alunos/{idAluno}/avaliacoes")
public class AvaliacaoController {
	
	private final AlunoRepository alunoRepository;
	private final AvaliacaoRepository repository;
	
	public AvaliacaoController(AlunoRepository alunoRepository, AvaliacaoRepository repository) {
		this.alunoRepository = alunoRepository;
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@PathVariable Long idAluno, @RequestBody @Valid AvaliacaoDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro de fornecedor para o id informado"));
		
		Avaliacao novaavaliacao = request.paraAvaliacao(aluno);
		repository.save(novaavaliacao);
		
		URI location = uriComponentsBuilder.path("/alunos/{idAluno}/avaliacoes/{id}").buildAndExpand(aluno.getId(),novaavaliacao.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
