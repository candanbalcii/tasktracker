package com.project.tasktracker.mappers;

import com.project.tasktracker.domain.dto.TaskListDto;
import com.project.tasktracker.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
