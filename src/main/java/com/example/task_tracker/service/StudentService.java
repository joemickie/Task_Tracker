package com.example.task_tracker.service;

import com.example.task_tracker.dto.StudentDto;
import com.example.task_tracker.dto.StudentSignUpDto;

public interface StudentService {

    StudentDto login(String email, String password);
    StudentDto signUp(StudentSignUpDto request);
    StudentDto getStudent(Long studentId);


}
