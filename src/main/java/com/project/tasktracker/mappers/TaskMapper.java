package com.project.tasktracker.mappers;

import com.project.tasktracker.domain.dto.TaskDto;
import com.project.tasktracker.domain.entities.Task;

public interface TaskMapper {

     Task fromDto(TaskDto taskDto);

     TaskDto toDto(Task task);
}
