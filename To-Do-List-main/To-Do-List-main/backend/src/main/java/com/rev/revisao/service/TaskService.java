package com.rev.revisao.service;

import com.rev.revisao.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    // Create a new task
    public Task createTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    // Update a task
    public Task updateTask(Long id, Task task) {
        Task existingTask = findTaskById(id);
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setCompleted(task.isCompleted());
            return existingTask;
        }
        throw new RuntimeException("Task not found");
    }

    // Delete a task
    public void deleteTask(Long id) {
        Task existingTask = findTaskById(id);
        if (existingTask != null) {
            tasks.remove(existingTask);
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    // Helper method to find a task by ID
    private Task findTaskById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }
}
