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

@RestController
@RequestMapping("/task-api/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO data) {
        Task task = this.taskService.createTask(data);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = this.taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable @Valid Long id) {
        Task task = this.taskService.findTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
