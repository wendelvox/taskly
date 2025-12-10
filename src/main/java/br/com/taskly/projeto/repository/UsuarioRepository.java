package br.com.taskly.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.taskly.projeto.model.UsuarioEntity;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

}
