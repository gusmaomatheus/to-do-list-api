package me.gusmaomatheus.todolist.dto;

import me.gusmaomatheus.todolist.enums.TaskPriorityLevel;

public record TaskDTO(
        String title,
        String description,
        Boolean active,
        TaskPriorityLevel priority
        ) {
}
