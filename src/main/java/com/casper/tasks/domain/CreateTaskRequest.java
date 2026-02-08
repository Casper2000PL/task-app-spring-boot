package com.casper.tasks.domain;

import com.casper.tasks.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
		String title,
		String description,
		LocalDate dueDate,
		TaskPriority priority
) {

}
