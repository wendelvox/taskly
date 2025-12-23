package br.com.taskly.projeto.dto;


import org.springframework.beans.BeanUtils;
import br.com.taskly.projeto.model.RecursoEntity;

public class RecursoDTO {
	
	
	private Integer id;
	private String nome;
	private String chave;
	
	public RecursoDTO() {
		
	}

	public RecursoDTO(RecursoEntity recurso) {
		BeanUtils.copyProperties(recurso, this);
		
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
	
	

}
