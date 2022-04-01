package br.com.zup.edu.avaliacoesalunos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private String texto;
    
    @ManyToOne(optional = false)
	private Aluno aluno;

	public Avaliacao(String titulo, String texto, Aluno aluno) {
		this.titulo = titulo;
		this.texto = texto;
		this.aluno = aluno;
	}
    
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
	public Avaliacao() {
		
	}
    
    public Long getId() {
        return id;
    }
}
