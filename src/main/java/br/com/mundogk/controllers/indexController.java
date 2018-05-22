package br.com.mundogk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mundogk.modells.Artigo;
import br.com.mundogk.repository.ArtigoRepository;

@Controller
public class indexController {
	
	@Autowired
	ArtigoRepository ar;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		Iterable<Artigo> artigos = ar.findAll();//lista os meus artigos
		mav.addObject("artigos", artigos);
		return mav;
	}

}
