package me.gusmaomatheus.todolist.service;

import jakarta.persistence.EntityNotFoundException;
import me.gusmaomatheus.todolist.dto.TaskDTO;
import me.gusmaomatheus.todolist.exceptions.TitleAlreadyExistsException;
import me.gusmaomatheus.todolist.exceptions.TitleLengthException;
import me.gusmaomatheus.todolist.model.Task;
import me.gusmaomatheus.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task findTaskById(UUID id) {
        return this.taskRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Not found task by id '%s'!".formatted(id))
                );
    }

    @Override
    public Optional<Task> findTaskByTitle(TaskDTO data) {
        String title = data.title();
        return this.getAllTasks()
                .stream()
                .filter(task -> task.getTitle().equals(title)).findFirst();
    }

    @Override
    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    public Task createTask(TaskDTO data) {
        if (this.taskTitleAlreadyExists(data)) {
            throw new TitleAlreadyExistsException("Já existe uma tarefa cadastrada com esse título.");
        }
        if (!this.taskTitleLengthValid(data)) {
            throw new TitleLengthException("O título deve conter entre 6 e 50 caracteres.");
        }
        Task task = new Task(data);
        return this.taskRepository.save(task);
    }

    @Override
    public Task updateTask(UUID id, TaskDTO data) {
        Task task = this.taskRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Not found task by id '%s'!".formatted(id))
        );
        task.setTitle(data.title());
        task.setDescription(data.description());
        task.setActive(data.active());
        task.setPriority(data.priority());
        return this.taskRepository.save(task);
    }

    @Override
    public void deleteTask(UUID id) {
        Task task = this.taskRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Not found task by id '%s'!".formatted(id))
        );
        this.taskRepository.delete(task);
    }

    public boolean taskTitleAlreadyExists(TaskDTO data) {
        Optional<Task> optionalTask = this.findTaskByTitle(data);
        return optionalTask.isPresent();
    }

    public boolean taskTitleLengthValid(TaskDTO data) {
        return data.title().length() <= 50 && data.title().length() >= 6;
    }
}
