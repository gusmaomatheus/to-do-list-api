package me.gusmaomatheus.todolist.enums;

import lombok.Getter;

@Getter
public enum TaskPriorityLevel {

    HIGH("Alto"),
    MEDIUM("Médio"),
    LOW("Baixo");

    private final String label;

    TaskPriorityLevel(String label) {
        this.label = label;
    }
}
