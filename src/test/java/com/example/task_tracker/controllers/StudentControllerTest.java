package com.example.task_tracker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.task_tracker.dto.StudentSignUpDto;
import com.example.task_tracker.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private StudentService studentService;

    @Test
    void register() throws Exception {
        StudentSignUpDto studentSignUpRequest = StudentSignUpDto.builder()
                .name("test_student")
                .email("test@gmail.com")
                .password("A4twenty")
                .build();


        String requestBody = objectMapper.writeValueAsString(studentSignUpRequest);
        mockMvc.perform(post("api/v1/students/new",201)
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isCreated());

    }

    @Test
    void getUser() {
    }
}