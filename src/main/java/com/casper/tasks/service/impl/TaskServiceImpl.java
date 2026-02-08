package com.casper.tasks.service.impl;

import com.casper.tasks.domain.CreateTaskRequest;
import com.casper.tasks.domain.entity.Task;
import com.casper.tasks.domain.entity.TaskStatus;
import com.casper.tasks.repository.TaskRepository;
import com.casper.tasks.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();

        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );

        return taskRepository.save(task);
    }
}
