package br.com.alura.listaVip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listaVip.model.Convidado;
import br.com.alura.listaVip.repository.ConvidadoRepository;

@Service	
public class ConvidadoService {
	

	@Autowired
	private ConvidadoRepository repository;

	
	public Iterable<Convidado> obterTodos(){
		
		Iterable<Convidado> convidados = repository.findAll();
		
		return convidados;
	}
	
	public void salvar(Convidado convidado){
		
		repository.save(convidado);
		
		
	}
}
