package com.casper.tasks.mapper.impl;

import com.casper.tasks.domain.CreateTaskRequest;
import com.casper.tasks.domain.dto.CreateTaskRequestDto;
import com.casper.tasks.domain.dto.TaskDto;
import com.casper.tasks.domain.entity.Task;
import com.casper.tasks.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
  @Override
  public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
	return new CreateTaskRequest(
			dto.title(),
			dto.description(),
			dto.dueDate(),
			dto.priority()
	);
  }

  @Override
  public TaskDto toDto(Task task) {
	return new TaskDto(
			task.getId(),
			task.getTitle(),
			task.getDescription(),
			task.getDueDate(),
			task.getPriority(),
			task.getStatus()
	);
  }
}
