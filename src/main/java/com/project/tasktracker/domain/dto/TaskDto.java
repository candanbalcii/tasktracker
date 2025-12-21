package com.project.tasktracker.domain.dto;

import com.project.tasktracker.domain.entities.TaskPriority;
import com.project.tasktracker.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status

) {
}
