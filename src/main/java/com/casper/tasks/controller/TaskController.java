package com.casper.tasks.controller;

import com.casper.tasks.domain.CreateTaskRequest;
import com.casper.tasks.domain.dto.CreateTaskRequestDto;
import com.casper.tasks.domain.dto.TaskDto;
import com.casper.tasks.domain.entity.Task;
import com.casper.tasks.mapper.TaskMapper;
import com.casper.tasks.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
  private final TaskService taskService;
  private final TaskMapper taskMapper;


  public TaskController(TaskService taskService, TaskMapper taskMapper) {
	this.taskService = taskService;
	this.taskMapper = taskMapper;
  }

  @PostMapping
  public ResponseEntity<TaskDto> createTask(
		  @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
  ) {
	CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
	Task task = taskService.createTask(createTaskRequest);
	TaskDto createdTaskDto = taskMapper.toDto(task);

	return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<TaskDto>> listTasks() {
	List<Task> tasks = taskService.listTasks();
	List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();

	return new ResponseEntity<>(taskDtos, HttpStatus.OK);
  }
}
