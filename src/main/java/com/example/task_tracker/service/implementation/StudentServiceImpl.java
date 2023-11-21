package com.example.task_tracker.service.implementation;

import com.example.task_tracker.dto.StudentDto;
import com.example.task_tracker.dto.StudentSignUpDto;
import com.example.task_tracker.entities.Student;
import com.example.task_tracker.exception.BadRequestException;
import com.example.task_tracker.exception.EntityNotFoundException;
import com.example.task_tracker.repositories.StudentRepository;
import com.example.task_tracker.service.StudentService;
import com.example.task_tracker.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public StudentDto login(String email, String password) {
        Student student = studentRepository.findByEmailAndPassword(email, password)
                .orElseThrow(()-> new BadRequestException("user not found"+ "input a valid email and password"));
        return Mapper.studentToStudentDto(student);
    }
    @Override
    public StudentDto signUp(StudentSignUpDto request) {
        return Mapper.studentToStudentDto(studentRepository.save(
                Student.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .build()
        ));
    }
    @Override
    public StudentDto getStudent(Long id) {
        return Mapper.studentToStudentDto (studentRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("User not Found","Provide valid user id")));
    }
}
