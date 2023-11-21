package com.example.task_tracker.controllers;

import com.example.task_tracker.dto.StudentDto;
import com.example.task_tracker.dto.StudentSignUpDto;
import com.example.task_tracker.service.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@AllArgsConstructor
@RequestMapping("api/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/new")
    public ResponseEntity<StudentDto> register(@Valid @RequestBody StudentSignUpDto signUpRequest){
        return new ResponseEntity<>(studentService.signUp(signUpRequest),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudent(id),HttpStatus.ACCEPTED);
    }

}
