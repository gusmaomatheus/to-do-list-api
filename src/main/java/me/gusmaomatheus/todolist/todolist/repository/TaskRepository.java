package me.gusmaomatheus.todolist.todolist.repository;

import me.gusmaomatheus.todolist.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
