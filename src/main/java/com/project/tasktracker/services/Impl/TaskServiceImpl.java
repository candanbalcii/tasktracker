package com.project.tasktracker.services.Impl;

import com.project.tasktracker.domain.entities.Task;
import com.project.tasktracker.repositories.TaskRepository;
import com.project.tasktracker.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId );
    }
}
