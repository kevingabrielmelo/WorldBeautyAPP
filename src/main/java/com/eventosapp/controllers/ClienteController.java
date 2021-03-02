package com.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.models.Cliente;
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
		Iterable<Cliente> clientes = clienteRepository.findAll();
		mv.addObject("eventos", clientes);
		return mv;
	}
//	
//	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
//	public ModelAndView detalhesEvento(@PathVariable("codigo") Long codigo) {
//		Evento evento = eventoRepository.findByCodigo(codigo);
//		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
//		mv.addObject("evento", evento);
//		
//		Iterable<Convidado> convidados = cr.findByEvento(evento);
//		mv.addObject("convidados", convidados);
//		return mv;
//	}
//	
	@RequestMapping("/deletar")
	public String deletarEvento(Long id) {
		Cliente evento = clienteRepository.findById(id);
		clienteRepository.delete(evento);
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
}
