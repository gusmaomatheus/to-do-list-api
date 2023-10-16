package me.gusmaomatheus.todolist.controller;

import jakarta.validation.Valid;
import me.gusmaomatheus.todolist.dto.TaskDTO;
import me.gusmaomatheus.todolist.model.Task;
import me.gusmaomatheus.todolist.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task-api")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO data) {
        Task task = this.taskService.createTask(data);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = this.taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable @Valid UUID id) {
        Task task = this.taskService.findTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
