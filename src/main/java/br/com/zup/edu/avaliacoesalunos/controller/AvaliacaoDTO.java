package br.com.zup.edu.avaliacoesalunos.controller;

import javax.validation.constraints.NotBlank;

import br.com.zup.edu.avaliacoesalunos.model.Aluno;
import br.com.zup.edu.avaliacoesalunos.model.Avaliacao;

public class AvaliacaoDTO {
	
	@NotBlank
	private String titulo;
    
	@NotBlank
    private String texto;

	public AvaliacaoDTO(@NotBlank String titulo, @NotBlank String texto) {
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public AvaliacaoDTO() {
		
	}
	
	public Avaliacao paraAvaliacao(Aluno aluno) {
		return new Avaliacao(titulo, texto, aluno);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}
}
