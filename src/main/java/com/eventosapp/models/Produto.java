package com.eventosapp.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy =
			GenerationType.SEQUENCE, 
	        generator = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente idCliente;
	
	private String nome_produto;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
}
