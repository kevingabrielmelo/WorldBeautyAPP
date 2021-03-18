package com.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.models.Cliente;
import com.eventosapp.models.NomePesq;
import com.eventosapp.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String form(Cliente cliente) {
		clienteRepository.save(cliente);
		return "redirect:/clientes";
	}
	
	@RequestMapping("/clientes")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("/evento/visualizarEvento");
		Iterable<Cliente> clientes = clienteRepository.findAllByOrderByNome();
		mv.addObject("eventos", clientes);
		return mv;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") Long id) {
		Cliente cliente = clienteRepository.findById(id);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("cliente", cliente);
		
//		Iterable<Convidado> convidados = cr.findByEvento(evento);
//		mv.addObject("convidados", convidados);
		return mv;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String form_update(Cliente cliente , Long id) {
		clienteRepository.findById(id);
		clienteRepository.save(cliente);
		return "redirect:/clientes";
	}
	
	@RequestMapping("/deletar")
	public String deletarEvento(Long id) {
		Cliente cliente = clienteRepository.findById(id);
		clienteRepository.delete(cliente);
		return "redirect:/clientes";
	}
	
	@RequestMapping("/update")
	public String form_update(Long id) {
		Cliente cliente = clienteRepository.findById(id);
		clienteRepository.save(cliente);
		return "redirect:/clientes";
	}
//	
//	@RequestMapping("/deletarConvidado")
//	public String deletarConvidado(String rg) {
//		Convidado convidado = cr.findByRg(rg);
//		cr.delete(convidado);
//		
//		Evento evento = convidado.getEvento();
//		long codigoLong = evento.getCodigo();
//		String codigo = "" + codigoLong;
//		return "redirect:/" + codigo;
//	}
//	
//	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
//	public String detalhesEventoPost(@PathVariable("id") Long id, Cliente cliente) {
//		Cliente cliente = clienteRepository.findById(id);
//		cliente.set(cliente);
//		clienteRepository.save(cliente);
//		return "redirect:/{codigo}";
//	}
	
	
	@RequestMapping("/pesqNome")
	public String pesqNome(String nome) {
	NomePesq.nomePesq  = nome;
	System.out.println(NomePesq.nomePesq);
		return "redirect:/usuario";

		
}
	
	@RequestMapping("/usuario")
	public ModelAndView RespEventos() {
		String nome = NomePesq.nomePesq; 
		ModelAndView mv = new ModelAndView("/evento/usuario");
		Iterable<Cliente> clientes = clienteRepository.findAllByNome(nome);
		mv.addObject("eventoPesqNome", clientes);
		return mv;
}

}
