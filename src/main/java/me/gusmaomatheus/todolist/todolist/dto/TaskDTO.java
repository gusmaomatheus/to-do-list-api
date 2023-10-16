package me.gusmaomatheus.todolist.todolist.dto;

import me.gusmaomatheus.todolist.todolist.enums.TaskPriorityLevel;

public record TaskDTO(
        String title,
        String description,
        Boolean active,
        TaskPriorityLevel priority
        ) {
}
