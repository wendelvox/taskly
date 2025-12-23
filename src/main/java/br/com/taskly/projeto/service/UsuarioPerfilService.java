package br.com.taskly.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taskly.projeto.dto.PerfilUsuarioDTO;
import br.com.taskly.projeto.model.UsuarioPerfilEntity;
import br.com.taskly.projeto.repository.UsuarioPerfilRepository;

@Service
public class UsuarioPerfilService {
	
	@Autowired
	private UsuarioPerfilRepository usuarioPefilRepository;

	
	public List<PerfilUsuarioDTO> listaTodos(){
		List<UsuarioPerfilEntity> usuarioPerfilEntity = usuarioPefilRepository.findAll();
		return usuarioPerfilEntity.stream().map(PerfilUsuarioDTO::new).toList();
		
	}
	
	public void inserir(PerfilUsuarioDTO usuario) {
		UsuarioPerfilEntity usuarioEntity = new UsuarioPerfilEntity(usuario);
		usuarioPefilRepository.save(usuarioEntity);
	}
	
	public PerfilUsuarioDTO alterar(PerfilUsuarioDTO usuario) {
		UsuarioPerfilEntity usuarioEntity = new UsuarioPerfilEntity(usuario);
		return new PerfilUsuarioDTO(usuarioPefilRepository.save(usuarioEntity));
	}
	
	
	public void excluir (Integer id) {
		UsuarioPerfilEntity usuario = usuarioPefilRepository.findById(id).get();
		usuarioPefilRepository.delete(usuario);
	}

}
