package com.rev.revisao.service;

import com.rev.revisao.dto.TaskDTO;
import com.rev.revisao.mapper.TaskMapper;
import com.rev.revisao.model.Task;
import com.rev.revisao.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pela lógica de negócio das tarefas.
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class TaskService {

    @Autowired
    private TaskRepository repository; // Acesso ao banco de dados

    @Autowired
    private TaskMapper mapper; // Conversão entre entidade e DTO

    // Retorna todas as tarefas como DTOs
    public List<TaskDTO> getAllTasks() {
        // Busca todas as tarefas, converte para DTO e retorna a lista
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // Busca uma tarefa por ID e retorna como DTO
    public TaskDTO getTaskById(Long id) {
        // Busca a tarefa pelo ID, lança exceção se não encontrar
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return mapper.toDTO(task);
    }

    // Cria uma nova tarefa a partir de um DTO
    public TaskDTO createTask(TaskDTO taskDTO) {
        // Converte DTO para entidade, define completed como false, salva e retorna DTO
        Task task = mapper.toEntity(taskDTO);
        task.setCompleted(false); // Garante valor padrão
        Task saved = repository.save(task);
        return mapper.toDTO(saved);
    }

    // Atualiza uma tarefa existente
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        // Busca a tarefa, atualiza os campos com dados do DTO, salva e retorna DTO atualizado
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        mapper.updateEntityFromDTO(taskDTO, task);
        Task updated = repository.save(task);
        return mapper.toDTO(updated);
    }

    // Deleta uma tarefa pelo ID
    public void deleteTask(Long id) {
        // Verifica se existe, lança exceção se não encontrar, senão deleta
        if (!repository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        repository.deleteById(id);
    }

    // Alterna o status de conclusão da tarefa
    public TaskDTO toggleTaskCompletion(Long id) {
        // Busca a tarefa, inverte o status de completed, salva e retorna DTO atualizado
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(!Boolean.TRUE.equals(task.getCompleted()));
        Task updated = repository.save(task);
        return mapper.toDTO(updated);
    }
}
