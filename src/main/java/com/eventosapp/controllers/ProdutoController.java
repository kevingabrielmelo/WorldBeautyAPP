package com.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eventosapp.models.Produto;
import com.eventosapp.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public String form() {
		return "evento/produtosEvento";
	}

	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public String form(Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/produtos";
	}
}
