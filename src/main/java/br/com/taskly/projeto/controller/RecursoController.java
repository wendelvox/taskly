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

import br.com.taskly.projeto.dto.RecursoDTO;
import br.com.taskly.projeto.service.RecursoService;

@RestController
@RequestMapping(value="/recurso")
@CrossOrigin
public class RecursoController {

    

	@Autowired
	private RecursoService recursoService;

	
	@GetMapping
	public List<RecursoDTO> listaTodos(){
		return recursoService.listaTodos();		
	}
	
	@PostMapping
	public void insert(@RequestBody RecursoDTO recurso) {
		recursoService.inserir(recurso);
	}
	
	@PutMapping
	public RecursoDTO alterar(@RequestBody RecursoDTO recurso) {
		return recursoService.alterar(recurso);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Integer id){
		recursoService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
	
	
}
