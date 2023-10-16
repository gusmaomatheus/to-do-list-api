package me.gusmaomatheus.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import me.gusmaomatheus.todolist.enums.TaskPriorityLevel;

public record TaskDTO(@NotBlank String title, @NotBlank String description, @NotNull Boolean active, @NotNull TaskPriorityLevel priority) {
}
