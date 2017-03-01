package br.com.alura.listaVip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.enviadoEmail.EmailService;
import br.com.alura.listaVip.model.Convidado;

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
			@RequestParam("telefone") String telefone, @RequestParam("senha")String senha, Model model ) {
		
		 Convidado novoConvidado = new Convidado(nome, email, telefone,senha);
		   service.salvar(novoConvidado);
		    
		    new EmailService().enviar(nome, email);
		    
		    Iterable<Convidado> convidados = service.obterTodos();
		   model.addAttribute("convidados",convidados);
		   return "listaconvidados";

	}
	
//	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
//	public ModelAndView home(){
//	ModelAndView modelAndView = new ModelAndView();
//	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	User user = (User) service.obterTodos();
//	modelAndView.addObject("userName", "Bem Vindo - " + user.getName());
//	modelAndView.addObject("adminMessage","Conteúdo disponível somente para usuários com função de administrador");
//	modelAndView.setViewName("admin/home");
//	return modelAndView;
//	}

}
