package com.casper.tasks.controller;

import com.casper.tasks.domain.CreateTaskRequest;
import com.casper.tasks.domain.UpdateTaskRequest;
import com.casper.tasks.domain.dto.CreateTaskRequestDto;
import com.casper.tasks.domain.dto.TaskDto;
import com.casper.tasks.domain.dto.UpdateTaskRequestDto;
import com.casper.tasks.domain.entity.Task;
import com.casper.tasks.mapper.TaskMapper;
import com.casper.tasks.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

  @PutMapping("/{taskId}")
  public ResponseEntity<TaskDto> updateTask(
		  @PathVariable UUID taskId,
		  @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto
  ) {
	UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
	Task task = taskService.updateTask(taskId, updateTaskRequest);
	TaskDto updatedTaskDto = taskMapper.toDto(task);

	return ResponseEntity.ok(updatedTaskDto);
  }

  @DeleteMapping("/{taskId}")
  public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
	taskService.deleteTask(taskId);

	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
