package com.example.task_tracker.repositories;

import com.example.task_tracker.dto.StudentSignUpDto;
import com.example.task_tracker.service.StudentService;
import com.example.task_tracker.service.TaskService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
class TaskRepositoryTest {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    TaskService taskService;
    StudentSignUpDto studentSignUpRequest;
    @BeforeEach
    void setUp() {

        studentSignUpRequest=new StudentSignUpDto("Tester","test@g.com","password");
        }



    @AfterEach
    void tearDown() {
    }

    @Test
    void findTasksByStudent_IdAndStatus() {

    }

    @Test
    void findTasksByStudent_Id() {

    }
}