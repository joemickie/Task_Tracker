package com.example.task_tracker.service;

import com.example.task_tracker.dto.TaskCreationDto;
import com.example.task_tracker.dto.TaskDto;
import com.example.task_tracker.dto.TaskUpdateDto;
import com.example.task_tracker.entities.Task;
import com.example.task_tracker.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskCreationDto taskDto);
    TaskDto  updateTask(TaskUpdateDto taskUpdateRequest, Long taskId);

    Task getTask(Long id);
    TaskDto getTaskDto(Long id);
    List<TaskDto> findAllByUserId(Long UserId);
    List<TaskDto> getTasksByStatus(TaskStatus status, Long studentId);
    TaskDto resetStatus(TaskStatus status, Long taskId);
    void delete(Long taskId);

}
