package me.gusmaomatheus.todolist.repository;

import me.gusmaomatheus.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
