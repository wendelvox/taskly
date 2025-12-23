package br.com.taskly.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.taskly.projeto.model.PerfilEntity;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Integer> {

}
