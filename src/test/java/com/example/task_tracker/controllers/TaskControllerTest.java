package com.example.task_tracker.controllers;

import com.example.task_tracker.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.task_tracker.dto.TaskDto;
import com.example.task_tracker.enums.TaskStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private TaskService taskService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void toCreateTask() throws Exception {
        TaskDto taskDto = TaskDto.builder()
                .title("test title")
                .description("I will sleep soon")
                .status(TaskStatus.PENDING)
                .build();


        String requestBody = objectMapper.writeValueAsString(taskDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/tasks/new", 201)
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isCreated());
    }
    @Test
    void update() {
    }

    @Test
    void getMyTasks() {
    }

    @Test
    void getATask() {
    }

    @Test
    void getDoneTask() {
    }

    @Test
    void getInProgressTask() {
    }

    @Test
    void setTaskDone() {
    }

    @Test
    void setTaskPending() {
    }

    @Test
    void deleteTask() {
    }
}