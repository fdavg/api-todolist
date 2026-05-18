package com.fdavg.apitodolist.service;

import com.fdavg.apitodolist.model.Task;
import com.fdavg.apitodolist.model.TaskStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class TaskService {

    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public Task create(String title, String description) {
        Long id = sequence.incrementAndGet();
        Task task = new Task(id, title, description);
        tasks.put(id, task);
        return task;
    }

    public List<Task> list() {
        List<Task> result = new ArrayList<>(tasks.values());
        result.sort(Comparator.comparing(Task::getId));
        return result;
    }

    public Task get(Long id) {
        Task task = tasks.get(id);
        if (task == null) {
            throw new ResponseStatusException(NOT_FOUND, "Task " + id + " not found");
        }
        return task;
    }

    public Task assign(Long id, String assignee) {
        Task task = get(id);
        task.assign(assignee);
        return task;
    }

    public Task updateStatus(Long id, TaskStatus status) {
        Task task = get(id);
        task.updateStatus(status);
        return task;
    }
}
