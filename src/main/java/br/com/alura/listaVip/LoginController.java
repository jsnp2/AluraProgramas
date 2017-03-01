package br.com.alura.listaVip;



import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.listaVip.model.Convidado;


@Controller
public class LoginController {

	@RequestMapping(value = "login" )
	public String login(){
		
		return "login";
	}
	
	
}
