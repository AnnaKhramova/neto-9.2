package ru.akhramova.task_9_2.model;

public record ErrorResponse(
        int errorCode,
        String errorMessage)  {
}