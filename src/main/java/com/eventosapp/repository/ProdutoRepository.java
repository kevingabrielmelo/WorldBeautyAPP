package com.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String> {

//	Produto findById(Long id_produto);
//	Iterable<Cliente> findByEvento();
//	Convidado findByRg(String rg);
}