package com.project.tasktracker.services.Impl;

import com.project.tasktracker.domain.entities.TaskList;
import com.project.tasktracker.repositories.TaskListRepository;
import com.project.tasktracker.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


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

    @Override
    public TaskList createTaskList(TaskList taskList) {

        if(null != taskList.getId()){
            throw new IllegalArgumentException("tasklist already has an id");
        }
        if( null == taskList.getTitle() || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("There must be task list title!");
        }

        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
       if (null == taskList.getId()){
           throw new IllegalArgumentException("Task List must have ID");
       }
       if(!Objects.equals(taskList.getId(),taskListId)){
           throw new IllegalArgumentException("task list id change is not allowed");

        }

       TaskList existingTaskList = taskListRepository.findById(taskListId).orElseThrow(() ->
               new IllegalArgumentException("Task list is not found"));

       existingTaskList.setTitle(taskList.getTitle());
       existingTaskList.setDescription(taskList.getDescription());
       existingTaskList.setUpdated(LocalDateTime.now());

       return taskListRepository.save(existingTaskList);

    }

    @Override
    public void deleteTaskList(UUID taskListId) {
        taskListRepository.deleteById(taskListId);
    }

}
