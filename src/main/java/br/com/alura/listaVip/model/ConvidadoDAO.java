package br.com.alura.listaVip.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


@Repository
public class ConvidadoDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
	
	
	public Convidado loadUserByUsername (String email){
		 List<Convidado> convidados = manager.createQuery("select u from Convidado u where u.email = :email", Convidado.class)
		            .setParameter("email", email)
		            .getResultList();

		    if(convidados.isEmpty()){
		        throw new UsernameNotFoundException("O usuário "+ email +" não foi encontrado");
		    }

		    return convidados.get(0);
		
	}


	
}
