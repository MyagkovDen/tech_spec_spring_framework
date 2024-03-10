package com.example.homework11.service;

import com.example.homework11.aspects.TrackUserAction;
import com.example.homework11.model.Task;
import com.example.homework11.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@TrackUserAction
@Service
public class TaskService {
    TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> getTaskByStatus(@RequestParam Task.TaskStatus status) {
        return repository.findByStatus(status);
    }

    public int updateTaskStatus(Task.TaskStatus status, Long id) {
        return repository.updateTaskStatus(status, id);
    }

    public void deleteById(Long id) {
         repository.deleteTaskById(id);
    }
}
