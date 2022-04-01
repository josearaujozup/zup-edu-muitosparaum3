package br.com.zup.edu.avaliacoesalunos.controller;

import javax.validation.constraints.NotBlank;

import br.com.zup.edu.avaliacoesalunos.model.Aluno;

public class AlunoDTO {
	
	@NotBlank
    private String nome;
    
	@NotBlank
    private String email;
    
	@NotBlank
    private String bootcamp;

	public AlunoDTO(String nome, String email, String bootcamp) {
		super();
		this.nome = nome;
		this.email = email;
		this.bootcamp = bootcamp;
	}
	
	public AlunoDTO() {
		
	}
	
	public Aluno paraAluno() {
		return new Aluno(nome,email,bootcamp);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getBootcamp() {
		return bootcamp;
	}
}
