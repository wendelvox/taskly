package br.com.taskly.projeto.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.taskly.projeto.dto.PerfilDTO;
import br.com.taskly.projeto.dto.PerfilUsuarioDTO;
import br.com.taskly.projeto.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pfu_perfil_usuario")
public class UsuarioPerfilEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="pfu_id_perfil_usuario")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="usr_id_usuario")	
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name="pfl_id_perfil")	
	private PerfilEntity perfil;
	
	
	
	public UsuarioPerfilEntity() {
		
	}
	
	public UsuarioPerfilEntity(PerfilUsuarioDTO perfilUsuarioDTO) {
		BeanUtils.copyProperties(perfilUsuarioDTO, this);
		if(perfilUsuarioDTO !=null && perfilUsuarioDTO.getUsuario() !=null) {
			
		 this.usuario = new UsuarioEntity(perfilUsuarioDTO.getUsuario());
		}
		if(perfilUsuarioDTO !=null && perfilUsuarioDTO.getPerfil()!=null) {
			this.perfil = new PerfilEntity(perfilUsuarioDTO.getPerfil());
		}
		
	}

	
	
	public Integer getId() {
		return id;
	}	

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public PerfilEntity getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEntity perfil) {
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
		UsuarioPerfilEntity other = (UsuarioPerfilEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
