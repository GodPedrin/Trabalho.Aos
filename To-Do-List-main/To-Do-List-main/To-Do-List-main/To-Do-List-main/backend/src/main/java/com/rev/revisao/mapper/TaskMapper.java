package com.rev.revisao.mapper;

// Importa as classes necessárias
import com.rev.revisao.model.Task;
import com.rev.revisao.dto.TaskDTO;
import org.springframework.stereotype.Component;

/**
 * Mapper responsável por converter entre a entidade Task e o DTO TaskDTO.
 * Facilita a separação entre as camadas de persistência e apresentação.
 */
@Component // Torna o mapper um bean gerenciado pelo Spring
public class TaskMapper {

    // Converte uma entidade Task em um DTO TaskDTO
    public TaskDTO toDTO(Task task) {
        if (task == null) return null;
        return new TaskDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getCompleted()
        );
    }

    // Converte um DTO TaskDTO em uma entidade Task
    public Task toEntity(TaskDTO dto) {
        if (dto == null) return null;
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.getCompleted());
        return task;
    }

    // Atualiza uma entidade Task existente com dados de um TaskDTO
    public void updateEntityFromDTO(TaskDTO dto, Task task) {
        if (dto == null || task == null) return;
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.getCompleted());
    }
}