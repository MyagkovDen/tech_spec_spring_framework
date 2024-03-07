package com.example.homework5.controller;

import com.example.homework5.model.Task;
import com.example.homework5.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tasks-service")
@RestController
public class TaskController {
    TaskService service;

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
        return service.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> findByStatus(@PathVariable Task.TaskStatus status) {
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

    @GetMapping("/hello")
    String addTask() {
        return "Hello from Tasks Service!";
    }
}
