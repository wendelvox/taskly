package br.com.taskly.projeto.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.taskly.projeto.dto.RecursoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="rcs_recurso")
public class RecursoEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rcs_id_recurso")
	private Integer id;
	
	@Column(name="rcs_ds_nome", nullable = false)
	private String nome;
	
	@Column(name="rcs_ds_chave", nullable = false)
	private String chave;
	
	public RecursoEntity() {
		
	}
	
	public RecursoEntity(RecursoDTO recursoDTO) {
		BeanUtils.copyProperties(recursoDTO, this);
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

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
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
		RecursoEntity other = (RecursoEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
