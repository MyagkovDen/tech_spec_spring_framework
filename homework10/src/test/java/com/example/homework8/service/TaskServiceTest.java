package com.example.homework8.service;

import com.example.homework8.model.Task;
import com.example.homework8.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;
    @InjectMocks
    TaskService taskService;

    @Test
    void addTask() {
        Task task = Task.builder()
                .description("go to pool").build();
        when(taskRepository.save(task)).thenReturn(any(Task.class));

        taskService.addTask(task);

        verify(taskRepository, times(1)).save(task);

    }

    @Test
    void getAllTasks() {
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);
        List<Task> tasks  = List.of(task1, task2);
        when(taskRepository.findAll()).thenReturn(tasks);

        taskService.getAllTasks();

        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void getTaskByStatus() {
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);
        List<Task> tasks  = List.of(task1, task2);
        when(taskRepository.findByStatus(Task.TaskStatus.CREATED))
                .thenReturn(tasks);

        taskService.getTaskByStatus(Task.TaskStatus.CREATED);

        verify(taskRepository, times(1)).findByStatus(Task.TaskStatus.CREATED);

    }

    @Test
    void updateTaskStatus() {
        when(taskRepository.updateTaskStatus( eq(Task.TaskStatus.DONE), eq(1L)))
                .thenReturn(1);

        taskService.updateTaskStatus(Task.TaskStatus.DONE, 1L);

        verify(taskRepository, times(1)).updateTaskStatus(Task.TaskStatus.DONE, 1L);

    }
}