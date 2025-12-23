package br.com.taskly.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taskly.projeto.dto.PerfilDTO;
import br.com.taskly.projeto.model.PerfilEntity;
import br.com.taskly.projeto.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;

	
	public List<PerfilDTO> listaTodos(){
		List<PerfilEntity> perfilEntity = perfilRepository.findAll();
		return perfilEntity.stream().map(PerfilDTO::new).toList();
	}
	
	public void inserir(PerfilDTO perfil) {
		PerfilEntity perfilEntity = new PerfilEntity(perfil);
		perfilRepository.save(perfilEntity);
	}
	
	public PerfilDTO alterar(PerfilDTO perfil) {
		PerfilEntity perfilEntity = new PerfilEntity(perfil);
		return new PerfilDTO(perfilRepository.save(perfilEntity));
	}
	
	public void excluir(Integer id) {
		PerfilEntity perfil = perfilRepository.findById(id).get();
		perfilRepository.delete(perfil);
	}
	
}
