package br.com.taskly.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.taskly.projeto.model.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Integer> {

}
