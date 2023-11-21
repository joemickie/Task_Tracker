package com.example.task_tracker.exception;

import lombok.Data;

@Data
public class EntityNotFoundException extends RuntimeException{
    private String debugMessage;
    public EntityNotFoundException(String message, String debugMessage){
        super(message);

        this.debugMessage= debugMessage;
    }
}
