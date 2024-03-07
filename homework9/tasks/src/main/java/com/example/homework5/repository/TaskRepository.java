package com.example.homework5.repository;

import com.example.homework5.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * Добавление задачи
     */
    Task save(Task task);

    /**
     * Просмотр всех задач
     */
    List<Task> findAll();

    /**
     * Просмотр задач по статусу
     */
    List<Task> findByStatus(Task.TaskStatus status);

    /**
     * Изменение статуса задачи
     */
    @Transactional
    @Modifying
    @Query("update Task t " +
           "set t.status = :status " +
           "where t.id = :id")
    int updateTaskStatus(Task.TaskStatus status, Long id);

    /**
     * Удаление задачи
     */
    @Transactional
    void deleteTaskById(Long id);

}
