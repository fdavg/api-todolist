package com.fdavg.apitodolist.model;

import java.time.Instant;

public record TaskStatusChange(TaskStatus status, Instant changedAt) {
}
