package com.casper.tasks.mapper;

import com.casper.tasks.domain.CreateTaskRequest;
import com.casper.tasks.domain.UpdateTaskRequest;
import com.casper.tasks.domain.dto.CreateTaskRequestDto;
import com.casper.tasks.domain.dto.TaskDto;
import com.casper.tasks.domain.dto.UpdateTaskRequestDto;
import com.casper.tasks.domain.entity.Task;

public interface TaskMapper {
  CreateTaskRequest fromDto(CreateTaskRequestDto dto);

  TaskDto toDto(Task task);

  UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);
}
