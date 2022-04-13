package model.usuario;

import javax.persistence.Entity;

import base.BaseEntity;

@Entity
public class Usuario extends BaseEntity {
	
	private String email;
	private String senhaCriptografada;
	private String nome;
	
	public Usuario(String email, String senhaCriptografada, String nome) {
		super();
		this.email = email;
		this.senhaCriptografada = senhaCriptografada;
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}
	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
