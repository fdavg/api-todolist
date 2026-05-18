package com.fdavg.apitodolist.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Task {

    private final Long id;
    private final String title;
    private final String description;
    private final Instant createdAt;
    private String assignee;
    private TaskStatus status;
    private Instant updatedAt;
    private final List<TaskStatusChange> statusHistory;

    public Task(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
        this.status = TaskStatus.TODO;
        this.statusHistory = new ArrayList<>();
        this.statusHistory.add(new TaskStatusChange(this.status, this.createdAt));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getAssignee() {
        return assignee;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public List<TaskStatusChange> getStatusHistory() {
        return List.copyOf(statusHistory);
    }

    public void assign(String assignee) {
        this.assignee = assignee;
        this.updatedAt = Instant.now();
    }

    public void updateStatus(TaskStatus status) {
        if (this.status == status) {
            return;
        }

        this.status = status;
        this.updatedAt = Instant.now();
        this.statusHistory.add(new TaskStatusChange(status, this.updatedAt));
    }
}
