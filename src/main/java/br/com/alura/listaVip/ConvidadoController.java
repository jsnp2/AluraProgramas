package br.com.alura.listaVip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.listaVip.model.Convidado;
import br.com.alura.listaVip.repository.ConvidadoRepository;


@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoRepository repository;

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model){

	    Iterable<Convidado> convidados = repository.findAll();
	    model.addAttribute("convidado", convidados);

		return "listaconvidados";
	}
	

	
		
}
