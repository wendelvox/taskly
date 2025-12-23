package br.com.taskly.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taskly.projeto.dto.RecursoDTO;
import br.com.taskly.projeto.model.RecursoEntity;
import br.com.taskly.projeto.repository.RecursoRepository;

@Service
public class RecursoService {
	
	@Autowired
	private RecursoRepository recursoRepository;

	public List<RecursoDTO> listaTodos(){
		List<RecursoEntity> recursoEntity = recursoRepository.findAll();
		return recursoEntity.stream().map(RecursoDTO::new).toList();
		
	}
	
	public void inserir(RecursoDTO recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		recursoRepository.save(recursoEntity);
	}
	
	public RecursoDTO alterar(RecursoDTO recurso) {
		RecursoEntity recuroEntity = new RecursoEntity(recurso);
		return new RecursoDTO(recursoRepository.save(recuroEntity));
	}
	
	public void excluir (Integer id) {
		RecursoEntity recurso = recursoRepository.findById(id).get();
		recursoRepository.delete(recurso);
	}
}
