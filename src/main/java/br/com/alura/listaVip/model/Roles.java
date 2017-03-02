package br.com.alura.listaVip.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Roles implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	@Id
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nome;
	}

}
