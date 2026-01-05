package com.project.tasktracker.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {

}
