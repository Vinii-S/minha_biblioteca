package br.ifba.demo.frontend.controller;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	@PostMapping("process_login")
	public ModelAndView postMethodName(HttpServletRequest request, Model model){
		//TODO: process POST request
		System.out.println("process_login");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		System.out.println("usuario: " + usuario);
		System.out.println("senha..: " + senha);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dashboard");
		return mav;
	}

	@GetMapping("/cadastrar_livro")
	public ModelAndView cadastrarLivro() {
		List<StatusLivro> status = new ArrayList<StatusLivro>();
		StatusLivro St1 = new StatusLivro(1,"Comprado");
		StatusLivro St2 = new StatusLivro(2,"Vendido");
		StatusLivro St3 = new StatusLivro(3,"Emprestado");
		StatusLivro St4 = new StatusLivro(4,"Desejado");
		
		status.add(St1);
		status.add(St2);
		status.add(St3);
		status.add(St4);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("edicao", 12);
		mav.addObject("lista", status);
		mav.setViewName("cadastrarLivro");
		return mav;
	}

	@GetMapping("processar_cadastro_livro")
	public ModelAndView processar_cadastro_livro(HttpServletRequest request, Model model){
		System.out.println("--------- usuario:" + request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ProcessarLivro");

		return mav;
	}
	
	
	
}
