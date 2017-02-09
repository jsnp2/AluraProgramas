package br.com.alura.listaVip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="convidado")
public class Convidado {

	@Id
	@GeneratedValue
	private long id;
	
	
	private String nome;
	private String email;
	private String telefone;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return telefone;
	}
	public void setTel(String telefone) {
		this.telefone = telefone;
	}
	
}
