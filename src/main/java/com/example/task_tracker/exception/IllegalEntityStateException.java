package com.example.task_tracker.exception;

public class IllegalEntityStateException extends RuntimeException {
    private  final String debugMessage;
    public IllegalEntityStateException(String message, String debugMessage) {
        super(message);
        this.debugMessage=debugMessage;
    }
}
