package com.fdavg.apitodolist.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskRequest(
        @NotBlank(message = "title is required")
        String title,
        String description
) {
}
