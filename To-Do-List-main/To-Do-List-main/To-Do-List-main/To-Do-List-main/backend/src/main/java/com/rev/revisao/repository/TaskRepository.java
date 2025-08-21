package com.rev.revisao.repository;

import com.rev.revisao.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository para a entidade Task.
 * Fornece métodos CRUD prontos por meio do JpaRepository.
 */
@Repository // Indica que é um componente de acesso a dados do Spring
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Métodos CRUD já disponíveis pelo JpaRepository
}
