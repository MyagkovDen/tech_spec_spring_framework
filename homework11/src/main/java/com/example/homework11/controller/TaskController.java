package com.example.homework11.controller;

import com.example.homework11.model.Task;
import com.example.homework11.service.TaskService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    TaskService service;
    private final Counter counter = Metrics.counter("request_counter");
    private final Timer timer = Metrics.timer("request_timer");

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/add")
    Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> findAll() {
        counter.increment();
        return service.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> findByStatus(@PathVariable Task.TaskStatus status) {
        timer.count();
        return service.getTaskByStatus(status);
    }

    @PutMapping("/task/{id}")
    public int updateTaskByStatus(@RequestParam Task.TaskStatus status, @PathVariable Long id) {
        return service.updateTaskStatus(status, id);
    }

    @GetMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
