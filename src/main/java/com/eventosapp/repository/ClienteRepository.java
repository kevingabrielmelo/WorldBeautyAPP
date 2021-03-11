package com.eventosapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

	//Procura cliente por ID
	Cliente findById(Long codigo);

	//Procura cliente pelo nome
	Iterable<Cliente> findAllByNome(String nome);
	
	//Ordena em ordem alfabética
	public List<Cliente> findAllByOrderByNome();
	
}
