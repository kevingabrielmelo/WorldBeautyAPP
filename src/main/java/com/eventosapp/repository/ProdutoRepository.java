package com.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	Iterable<Produto> findAllByIdCliente(long id);
	
}
