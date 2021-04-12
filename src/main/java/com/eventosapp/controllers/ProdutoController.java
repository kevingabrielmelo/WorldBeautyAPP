package com.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.models.Cliente;
import com.eventosapp.models.Produto;
import com.eventosapp.repository.ClienteRepository;
import com.eventosapp.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@RequestMapping(value = "/produtos")
	public String form() {
		return "evento/produtosEvento";
	}

	@RequestMapping(value = "/produtos_{id}", method = RequestMethod.POST)
	public String form_update(Produto produto, @PathVariable("id") Long id) {
		produto.setIdCliente(id);
		produto.setId(0);
		produtoRepository.save(produto);
		return "redirect:/produtos_{id}";

	}

	@RequestMapping(value = "/produtos_{id}", method = RequestMethod.GET)
	public ModelAndView detalhesProduto(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("evento/produtosEvento");
		Iterable<Produto> produto = produtoRepository.findAllByIdCliente(id);
		Cliente cliente = clienteRepository.findById(id);
		mv.addObject("cliente", cliente);
		mv.addObject("produto", produto);
		return mv;
	}
}
