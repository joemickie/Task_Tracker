package com.example.task_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class TaskCreationDto {
    private String title;
    @NotNull(message = "Task description cannot be empty")
    private String description;
    private Long studentId;
}
