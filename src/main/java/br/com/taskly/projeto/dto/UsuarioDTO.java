package br.com.taskly.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.taskly.projeto.model.UsuarioEntity;

public class UsuarioDTO {

	
	private Integer id;	
	private String nome;
	private String login;
	private String senha;
	private String email;
	
	public UsuarioDTO () {
		
	}
	
	public UsuarioDTO(UsuarioEntity usuario) {
		BeanUtils.copyProperties(usuario, this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
	
	
}
