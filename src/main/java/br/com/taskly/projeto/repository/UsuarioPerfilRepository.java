package br.com.taskly.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.taskly.projeto.model.UsuarioPerfilEntity;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfilEntity, Integer> {

}
