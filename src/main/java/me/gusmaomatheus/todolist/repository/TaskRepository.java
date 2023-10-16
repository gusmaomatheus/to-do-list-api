package me.gusmaomatheus.todolist.repository;

import me.gusmaomatheus.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
