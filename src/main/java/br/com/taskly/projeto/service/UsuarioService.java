package br.com.taskly.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.taskly.projeto.dto.UsuarioDTO;
import br.com.taskly.projeto.model.UsuarioEntity;
import br.com.taskly.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@Autowired
	private PasswordEncoder passwordEnconder;
	
	public List<UsuarioDTO> listaTodos(){
		List<UsuarioEntity> usuarioEntity = usuarioRepository.findAll();
		return usuarioEntity.stream().map(UsuarioDTO::new).toList();
		
	}
	
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEnconder.encode(usuario.getSenha()));
		usuarioRepository.save(usuarioEntity);
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEnconder.encode(usuario.getSenha()));
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}
	
	
	public void excluir (Integer id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
}
