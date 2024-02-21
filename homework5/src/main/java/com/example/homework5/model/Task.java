package com.example.homework5.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NamedQuery(
        name = "Task.updateTaskStatus",
        query = "update Task t set t.status = :status where t.id = :id"
)
@Data
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String description;
    @Enumerated(EnumType.STRING)
    TaskStatus status;
    LocalDateTime created;

    @Builder
    public Task(String description) {
        this.description = description;
        this.status = TaskStatus.CREATED;
        this.created = LocalDateTime.now();
    }

    public static enum TaskStatus {
        CREATED,
        IN_PROGRESS,
        DONE
    }

}
