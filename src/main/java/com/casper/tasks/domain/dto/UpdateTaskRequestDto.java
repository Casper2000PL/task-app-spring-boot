package com.casper.tasks.domain.dto;

import com.casper.tasks.domain.entity.TaskPriority;
import com.casper.tasks.domain.entity.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto(
		@NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
		@Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
		String title,
		@Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
		@Nullable
		String description,
		@FutureOrPresent(message = ERROR_MESSAGE_DUE_DATE)
		@Nullable
		LocalDate dueDate,
		@NotNull(message = ERROR_MESSAGE_STATUS)
		TaskStatus status,
		@NotNull(message = ERROR_MESSAGE_PRIORITY)
		TaskPriority priority
) {
  private static final String ERROR_MESSAGE_TITLE_LENGTH =
		  "Title must be between 1 and 255 characters long.";
  private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
		  "Description must be at most 1000 characters long.";
  private static final String ERROR_MESSAGE_DUE_DATE =
		  "Due date cannot be in the past.";
  private static final String ERROR_MESSAGE_STATUS =
		  "Status must be specified.";
  private static final String ERROR_MESSAGE_PRIORITY =
		  "Priority must be specified.";

}

