package com.example.homework5.repository;

import com.example.homework5.model.Task;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;


class TaskRepositoryTest {

    TaskRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void addTask() {
        Task task = new Task("go to swim");
       // repository.addTask(task);
    }

    @Test
    void findAll() {
    }

    @Test
    void findByStatus() {
    }

    @Test
    void updateTaskByStatus() {
    }

    @Test
    void deleteTaskById() {
    }

    @Test
    void main() {
    }
}