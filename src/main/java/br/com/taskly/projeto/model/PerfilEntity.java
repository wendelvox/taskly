package br.com.taskly.projeto.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.taskly.projeto.dto.PerfilDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pfl_perfil")
public class PerfilEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pfl_id_perfil")
	private Integer id;
	
	@Column(name="pfl_des_descricao", nullable = false)
	private String descricao;

	
	
	public PerfilEntity() {
		
	}
	
	public PerfilEntity(PerfilDTO pefilDTO) {
		BeanUtils.copyProperties(pefilDTO, this);
		
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		PerfilEntity other = (PerfilEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
