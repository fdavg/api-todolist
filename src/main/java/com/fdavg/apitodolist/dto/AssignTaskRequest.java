package com.fdavg.apitodolist.dto;

import jakarta.validation.constraints.NotBlank;

public record AssignTaskRequest(
        @NotBlank(message = "assignee is required")
        String assignee
) {
}
