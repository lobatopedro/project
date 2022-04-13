package model.projeto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import base.BaseEntity;
import model.usuario.Usuario;

@Entity
public class Projeto extends BaseEntity {
	
	private String nome;
	
	private String identificador;
	
	private Usuario proprietario;
	
	private List<Usuario> participantes = new ArrayList<>();
	
	public Projeto(String nome, String identificador, Usuario proprietario, List<Usuario> participantes) {
		super();
		this.nome = nome;
		this.identificador = identificador;
		this.proprietario = proprietario;
		this.participantes = participantes;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

}
