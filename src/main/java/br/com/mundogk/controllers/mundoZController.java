package br.com.mundogk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mundogk.modells.Artigo;
import br.com.mundogk.repository.ArtigoRepository;


@Controller
@RequestMapping("/z")
public class mundoZController {

	@Autowired
	private ArtigoRepository ar;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("guerreiros/index");
		Iterable<Artigo> artigos = ar.findAll();//lista os meus artigos
		mav.addObject("artigos", artigos);
		return mav;
	}
}
