package com.example.task_tracker.util;

import com.example.task_tracker.dto.StudentDto;
import com.example.task_tracker.dto.TaskDto;
import com.example.task_tracker.entities.Student;
import com.example.task_tracker.entities.Task;

import java.util.Date;


public class Mapper {
    public static StudentDto studentToStudentDto(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .build();
    }
    public static TaskDto taskToTaskDto(Task task){
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .completedAt(task.getCompletedAt())
                .build();
    }
}
