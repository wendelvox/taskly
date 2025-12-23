package br.com.taskly.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taskly.projeto.dto.PerfilUsuarioDTO;
import br.com.taskly.projeto.service.UsuarioPerfilService;

@RestController
@RequestMapping (value = "/usuario-perfil")
@CrossOrigin
public class UsuarioPerfilController {
	
	@Autowired
	private UsuarioPerfilService usuarioPerfilService;
	
	
	@GetMapping
	public List<PerfilUsuarioDTO> listaTodos(){
		return usuarioPerfilService.listaTodos();
	}
	
	
	@PostMapping
	public void inserir(@RequestBody PerfilUsuarioDTO perfil) {
		usuarioPerfilService.inserir(perfil);
	}
	
	@PutMapping
	public PerfilUsuarioDTO alterar(@RequestBody PerfilUsuarioDTO perfil) {
		return usuarioPerfilService.alterar(perfil);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Integer id){
		usuarioPerfilService.excluir(id);
		return ResponseEntity.ok().build();
	}

}
