package com.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

	Cliente findById(Long codigo);
//	Iterable<Cliente> findByEvento();
//	Convidado findByRg(String rg);
	Iterable<Cliente> findAllByNome(String nome);
}
