package me.gusmaomatheus.todolist.service;

import me.gusmaomatheus.todolist.dto.TaskDTO;
import me.gusmaomatheus.todolist.model.Task;

import java.util.List;

public interface TaskService {

    Task findTaskById(Long id);
    List<Task> getAllTasks();
    Task createTask(TaskDTO data);
    Task updateTask(Long id, TaskDTO data);
    Task deleteTask(Long id);
}
