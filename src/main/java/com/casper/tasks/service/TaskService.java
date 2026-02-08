package com.casper.tasks.service;

import com.casper.tasks.domain.CreateTaskRequest;
import com.casper.tasks.domain.entity.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
}
