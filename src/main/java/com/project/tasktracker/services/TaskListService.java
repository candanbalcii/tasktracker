package com.project.tasktracker.services;

import com.project.tasktracker.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {

    List <TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
}
