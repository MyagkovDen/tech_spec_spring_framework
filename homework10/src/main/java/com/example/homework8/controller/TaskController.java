package com.example.homework8.controller;

import com.example.homework8.aspects.TrackUserAction;
import com.example.homework8.model.Task;
import com.example.homework8.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}
