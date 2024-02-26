package com.example.homework6.notes.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String content;
    LocalDateTime created;

    @Builder
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.created = LocalDateTime.now();
    }
}
