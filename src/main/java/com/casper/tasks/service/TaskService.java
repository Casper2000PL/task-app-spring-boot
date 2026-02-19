package com.casper.tasks.service;

import com.casper.tasks.domain.CreateTaskRequest;
import com.casper.tasks.domain.UpdateTaskRequest;
import com.casper.tasks.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
