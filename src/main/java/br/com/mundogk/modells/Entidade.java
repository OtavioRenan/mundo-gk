package br.com.mundogk.modells;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id_entidade;
	
	private String nome;
	
	
	public Long getId_entidade() {
		return id_entidade;
	}
	public void setId_entidade(Long id_entidade) {
		this.id_entidade = id_entidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
