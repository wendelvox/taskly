package br.com.taskly.projeto.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.taskly.projeto.model.UsuarioPerfilEntity;

public class PerfilUsuarioDTO {
	
	private Integer id;
	private UsuarioDTO usuario;
	private PerfilDTO perfil;
	
	
	public PerfilUsuarioDTO() {
		
	}
		
	public PerfilUsuarioDTO(UsuarioPerfilEntity usuarioPerfil) {
		BeanUtils.copyProperties(usuarioPerfil, this);
		if(usuarioPerfil !=null && usuarioPerfil.getUsuario() !=null) {
			
		 this.usuario = new UsuarioDTO(usuarioPerfil.getUsuario());
		}
		if(usuarioPerfil !=null && usuarioPerfil.getPerfil()!=null) {
			this.perfil = new PerfilDTO(usuarioPerfil.getPerfil());
		}
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public UsuarioDTO getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}


	public PerfilDTO getPerfil() {
		return perfil;
	}


	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfilUsuarioDTO other = (PerfilUsuarioDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
