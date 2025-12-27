package com.project.tasktracker.services.Impl;

import com.project.tasktracker.domain.entities.TaskList;
import com.project.tasktracker.repositories.TaskListRepository;
import com.project.tasktracker.services.TaskListService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }
}
