package me.gusmaomatheus.todolist.service;

import me.gusmaomatheus.todolist.dto.TaskDTO;
import me.gusmaomatheus.todolist.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task findTaskById(UUID id);

    List<Task> getAllTasks();

    Task createTask(TaskDTO data);

    Task updateTask(UUID id, TaskDTO data);

    void deleteTask(UUID id);
}
