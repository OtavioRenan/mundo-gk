package br.com.mundogk.controllers.back;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mundogk.modells.Artigo;
import br.com.mundogk.repository.ArtigoRepository;

@Controller
@RequestMapping("/main")
public class mainPanel {
	
	@Autowired
	private ArtigoRepository ar;
	
	
	@GetMapping("/panel")
	public ModelAndView main(Artigo artigo) {
		ModelAndView mav =  new ModelAndView("back/mainPanel");
		mav.addObject("artigo");
		return mav;
	}
	
	@PostMapping("/panel")
	public ModelAndView salvar(@Valid Artigo artigo, BindingResult result) {		
		if(result.hasErrors()) {
		 	return main(artigo);
		} else {
			ar.save(artigo);
			return new ModelAndView("redirect:/main/edit");			
		}		
	}
	
	@GetMapping("/edit")
	public ModelAndView controle(Artigo artigo) {		
		ModelAndView mav =  new ModelAndView("back/mainEdit");
		Iterable<Artigo> artigos = ar.findAll();//lista os meus artigos
		mav.addObject("artigos", artigos);
		return mav;
	}
	
	@GetMapping(value="view/{id_artigo}")
	public ModelAndView view(Artigo artigo, @PathVariable Long id_artigo) {
		ModelAndView mav = new ModelAndView("back/mainPanel");
		mav.addObject("artigo", ar.findById(id_artigo));
		return mav;		
	}
	
	@DeleteMapping(value="delete/{id_artigo}")
	public ModelAndView delete(@PathVariable("id_artigo") Long id_artigo) {
		this.ar.deleteById(id_artigo);		
		return new ModelAndView("redirect:/main/edit");
	}
	
}
