package br.com.alura.listaVip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.enviadoEmail.EmailService;
import br.com.alura.listaVip.model.Convidado;
import br.com.alura.listaVip.repository.ConvidadoRepository;

@Controller
public class ListaController {

	@Autowired
	private ConvidadoService service;

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> convidados = service.obterTodos();
		
		model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String Salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {
		
		 Convidado novoConvidado = new Convidado(nome, email, telefone);
		   service.salvar(novoConvidado);
		    
		    new EmailService().enviar(nome, email);
		    
		    Iterable<Convidado> convidados = service.obterTodos();
		   model.addAttribute("convidados",convidados);
		   return "listaconvidados";

	}
	
	@RequestMapping(value = "deletar", method = RequestMethod.POST)
	public String Deletar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model){
		
		
		
		return null;
	}

}
