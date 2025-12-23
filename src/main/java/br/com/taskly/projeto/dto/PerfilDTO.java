package br.com.taskly.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.taskly.projeto.model.PerfilEntity;

public class PerfilDTO {

	private Integer id;	
	
	private String descricao;
	
	

	public PerfilDTO() {
		
	}
	public PerfilDTO(PerfilEntity pefil) {
		BeanUtils.copyProperties(pefil, this);
		
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
	
	
	
}
