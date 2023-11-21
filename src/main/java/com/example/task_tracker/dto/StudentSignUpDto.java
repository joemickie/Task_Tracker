package com.example.task_tracker.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.Enumerated;


@Data
@AllArgsConstructor
@Builder
public class StudentSignUpDto {
@NotNull(message="name cannot be null")
@Size(min=2, message="name must be more than 1 letter")
    private String name;
@Email()
    private String email;

    @NotNull(message="name cannot be null")
    @Size(min=2, max=12, message="password must be between 2 and 12 characters")
    private String password;
}
