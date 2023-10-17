package me.gusmaomatheus.todolist.service;

import me.gusmaomatheus.todolist.dto.TaskDTO;
import me.gusmaomatheus.todolist.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    Task findTaskById(UUID id);

    Optional<Task> findTaskByTitle(TaskDTO data);

    List<Task> getAllTasks();

    Task createTask(TaskDTO data);

    Task updateTask(UUID id, TaskDTO data);

    void deleteTask(UUID id);
}
