package me.gusmaomatheus.todolist.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.gusmaomatheus.todolist.enums.TaskPriorityLevel;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, unique = true)
    @Size(min = 6, max = 50)
    private String title;
    private String description;
    private Boolean active;
    @Enumerated(EnumType.STRING)
    private TaskPriorityLevel priority;
}
