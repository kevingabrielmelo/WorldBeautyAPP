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

	@RequestMapping(value="/produtos", method=RequestMethod.GET)
	public String form() {
		return "evento/produtosEvento";
	}
	
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public String form(Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/produtos";
	}
	
//	@RequestMapping(value = "/{idProduto}", method = RequestMethod.GET)
//	public ModelAndView detalhesEvento(@PathVariable("id") Long id) {
//		Produto produto = produtoRepository.findById(id);
//		ModelAndView mv = new ModelAndView("evento/produtosEvento");
//		mv.addObject("produto", produto);
//		
////		Iterable<Convidado> convidados = cr.findByEvento(evento);
////		mv.addObject("convidados", convidados);
//		return mv;
//	}
	
//	@RequestMapping(value = "/{idProduto}", method = RequestMethod.POST)
//	public String form_update(Produto produto , Long id) {
//		produtoRepository.findById(id);
//		produtoRepository.save(produto);
//		return "redirect:/produtos";
//	}
}