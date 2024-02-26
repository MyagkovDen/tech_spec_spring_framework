package com.example.homework6.notes.service;

import com.example.homework6.notes.model.Note;
import com.example.homework6.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    public Note addNote(Note note) {
        note.setCreated(LocalDateTime.now());
        return repository.save(note);
    }

    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    public Optional<Note> getNoteById(@RequestParam Long id) {
        return repository.findById(id);
    }

    public int updateNote(Long id, Note note) {
        return repository.updateNote(id, note);
    }

    public void deleteById(Long id) {
         repository.deleteNoteById(id);
    }
}
