package com.ifsp.hto.carinho.backend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	public Login() {
		
	}


	public Login(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	String nome;
	@Enumerated(value = EnumType.STRING)
	TipoUsuario perfil;
	
	String usuario;

	String senha;

	String email;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Login(String nome, TipoUsuario perfil, String usuario, String senha, String email) {
		this.nome = nome;
		this.perfil = perfil;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public TipoUsuario getPerfil() {
		return perfil;
	}


	public void setPerfil(TipoUsuario perfil) {
		this.perfil = perfil;
	}


	

}
