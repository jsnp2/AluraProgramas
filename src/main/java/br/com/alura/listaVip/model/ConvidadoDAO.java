package br.com.alura.listaVip.model;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.listaVip.repository.Usuario;

public class ConvidadoDAO {


	private EntityManager manager;
	
	
	public Convidado find (String email){
		 List<Convidado> convidados = manager.createQuery("select u from Convidado where u.email = :email", Convidado.class)
		            .setParameter("email", email)
		            .getResultList();

		    if(convidados.isEmpty()){
		        throw new RuntimeException("O usuário "+ email +" não foi encontrado");
		    }

		    return convidados.get(0);
		
	}
}
