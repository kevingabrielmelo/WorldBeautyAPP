package com.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
//	Iterable<Cliente> findByEvento();
//	Convidado findByRg(String rg);
}
