package com.rev.revisao.controller;

import com.rev.revisao.dto.TaskDTO;
import com.rev.revisao.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelos endpoints da API de tarefas.
 */
@RestController // Indica que a classe é um controller REST do Spring
@RequestMapping("/api/tasks") // Define o prefixo dos endpoints
public class TaskController {

    @Autowired
    private TaskService taskService; // Injeta o serviço de tarefas

    // GET /api/tasks - Lista todas as tarefas
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // GET /api/tasks/{id} - Busca tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(taskService.getTaskById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/tasks - Cria nova tarefa
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO created = taskService.createTask(taskDTO);
        return ResponseEntity.status(201).body(created);
    }

    // PUT /api/tasks/{id} - Atualiza tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        try {
            TaskDTO updated = taskService.updateTask(id, taskDTO);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/tasks/{id} - Remove tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // PATCH /api/tasks/{id}/toggle - Alterna status de conclusão da tarefa
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<TaskDTO> toggleTaskCompletion(@PathVariable Long id) {
        try {
            TaskDTO toggled = taskService.toggleTaskCompletion(id);
            return ResponseEntity.ok(toggled);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}