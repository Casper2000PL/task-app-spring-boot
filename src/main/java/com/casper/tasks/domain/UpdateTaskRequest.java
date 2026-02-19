package com.casper.tasks.domain;

import com.casper.tasks.domain.entity.TaskPriority;
import com.casper.tasks.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
		String title,
		String description,
		LocalDate dueDate,
		TaskStatus status,
		TaskPriority priority
) {
}
