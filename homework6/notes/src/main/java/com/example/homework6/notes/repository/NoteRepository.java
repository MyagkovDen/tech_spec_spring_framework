package com.example.homework6.notes.repository;

import com.example.homework6.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    /**
     * Добавление заметки
     */
    Note save(Note note);

    /**
     * Просмотр всех заметок
     */
    List<Note> findAll();

    /**
     * Получение заметки по id
     */
    Optional<Note> findById(Long id);

    /**
     * Редактирование заметки
     */
    @Transactional
    @Modifying
    @Query("update Note n " +
           "set n.title = :#{#note.getTitle()}, " +
           "n.content = :#{#note.getContent()} " +
           "where n.id = :id")
    int updateNote(Long id, Note note);

    /**
     * Удаление заметки
     */
    @Transactional
    void deleteNoteById(Long id);

}
