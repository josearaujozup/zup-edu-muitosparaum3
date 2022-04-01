package br.com.zup.edu.avaliacoesalunos.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.avaliacoesalunos.model.Aluno;
import br.com.zup.edu.avaliacoesalunos.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	private final AlunoRepository repository;
	
	public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }
	
	@PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid AlunoDTO request, UriComponentsBuilder uriComponentsBuilder){

        Aluno novoAluno = request.paraAluno();

        repository.save(novoAluno);

        URI location = uriComponentsBuilder.path("/alunos/{id}")
                .buildAndExpand(novoAluno.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

