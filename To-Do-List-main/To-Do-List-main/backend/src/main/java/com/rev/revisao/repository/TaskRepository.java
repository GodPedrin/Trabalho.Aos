package com.rev.revisao.repository;

import com.rev.revisao.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(nextId++);
        }
        tasks.removeIf(t -> t.getId().equals(task.getId()));
        tasks.add(task);
        return task;
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public void deleteById(Long id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}
