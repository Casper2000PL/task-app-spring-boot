package com.casper.tasks.domain.dto;

import com.casper.tasks.domain.entity.TaskPriority;
import com.casper.tasks.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
		UUID id,
		String title,
		String description,
		LocalDate dueDate,
		TaskPriority priority,
		TaskStatus status
) {
}
