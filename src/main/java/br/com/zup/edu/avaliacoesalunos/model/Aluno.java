package br.com.zup.edu.avaliacoesalunos.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String bootcamp;
    
    private LocalDateTime criadoEm=LocalDateTime.now();

	public Aluno(String nome, String email, String bootcamp) {
		this.nome = nome;
		this.email = email;
		this.bootcamp = bootcamp;
	}
	
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
	public Aluno() {
		
	}
    
    public Long getId() {
        return id;
    }
}
