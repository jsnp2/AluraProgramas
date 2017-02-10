package br.com.alura.listaVip.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="convidado")
public class Convidado {
	public Convidado(){}

	public Convidado(String nome, String email, String telefone){
	    this.nome = nome;
	    this.email = email;
	    this.telefone = telefone;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	
	private String nome;
	private String email;
	private String telefone;
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
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
	
}


