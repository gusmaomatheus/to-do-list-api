package me.gusmaomatheus.todolist.service;

import jakarta.persistence.EntityNotFoundException;
import me.gusmaomatheus.todolist.dto.TaskDTO;
import me.gusmaomatheus.todolist.model.Task;
import me.gusmaomatheus.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task findTaskById(Long id) {
        return this.taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found task by id '%d'!".formatted(id)));
    }

    @Override
    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    public Task createTask(TaskDTO data) {
        return null;
    }

    @Override
    public Task updateTask(Long id, TaskDTO data) {
        return null;
    }

    @Override
    public Task deleteTask(Long id) {
        return null;
    }
}
