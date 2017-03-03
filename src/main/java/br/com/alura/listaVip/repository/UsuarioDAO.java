package br.com.alura.listaVip.repository;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO implements UserDetailsService {
	
	private EntityManager manager;
	
	
	public Usuario loadUserByUsername (String email){
		 List<Usuario> usuarios = manager.createQuery("select u from Convidado where u.email = :email", Usuario.class)
		            .setParameter("email", email)
		            .getResultList();

		    if(usuarios.isEmpty()){
		        throw new UsernameNotFoundException("O usuário "+ email +" não foi encontrado");
		    }

		    return usuarios.get(0);
		
	}


}
