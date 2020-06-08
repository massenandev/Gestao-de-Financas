package br.com.massenan.gestaodefinancas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/contatos")
	public String contatos() {
		return "/contatos/contatos";
	}
	
	@GetMapping("/contas")
	public String contas() {
		return "/contas/contas";
	}
	
	@GetMapping("/documentos")
	public String documentos() {
		return "/documentos/documentos";
	}
}
