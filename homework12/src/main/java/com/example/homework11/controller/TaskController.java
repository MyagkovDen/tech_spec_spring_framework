package com.example.homework11.controller;

import com.example.homework11.model.Task;
import com.example.homework11.service.FileGateWay;
import com.example.homework11.service.TaskService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;
    private final FileGateWay fileGateWay;
    private final String request_file_name = "request.txt";
    private final Counter counter = Metrics.counter("request_counter");
    private final Timer timer = Metrics.timer("request_timer");


    @PostMapping("/add")
    Task addTask(HttpServletRequest request, @RequestBody Task task) {
        task.setStatus(Task.TaskStatus.CREATED);
        task.setCreated(LocalDateTime.now());
        fileGateWay.writeToFile(task.getDescription() + ".txt", task.toString());
        fileGateWay.writeToFile(request_file_name, getRequestInfo(request));
        return service.addTask(task);
    }

    private static String getRequestInfo(HttpServletRequest request) {
        StringBuilder requestInfo = new StringBuilder();
        requestInfo.append("Time: ").append(LocalDateTime.now()).append("\n");
        requestInfo.append("Method: ").append(request.getMethod()).append("\n");
        requestInfo.append("URI: ").append(request.getRequestURI()).append("\n\n");
        return requestInfo.toString();
    }

    @GetMapping("/tasks")
    public List<Task> findAll(HttpServletRequest request) {
        fileGateWay.writeToFile(request_file_name, getRequestInfo(request));
        counter.increment();
        return service.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> findByStatus(HttpServletRequest request,
                                   @PathVariable Task.TaskStatus status) {
        fileGateWay.writeToFile(request_file_name, getRequestInfo(request));
        timer.count();
        return service.getTaskByStatus(status);
    }

    @PutMapping("/task/{id}")
    public int updateTaskByStatus(HttpServletRequest request,
                                  @RequestParam Task.TaskStatus status, @PathVariable Long id) {
        fileGateWay.writeToFile(request_file_name, getRequestInfo(request));
        return service.updateTaskStatus(status, id);
    }

    @GetMapping("/delete/{id}")
    public void deleteTaskById(HttpServletRequest request,
                               @PathVariable Long id) {
        fileGateWay.writeToFile(request_file_name, getRequestInfo(request));
        service.deleteById(id);
    }
}
