package com.fdavg.apitodolist.dto;

import com.fdavg.apitodolist.model.TaskStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateTaskStatusRequest(
        @NotNull(message = "status is required")
        TaskStatus status
) {
}
