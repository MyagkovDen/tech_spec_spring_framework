package com.example.homework6.notes.controller;

import com.example.homework6.notes.model.Note;
import com.example.homework6.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class NoteController {
    private final NoteService service;

    @PostMapping("/add")
    Note addNote(@RequestBody Note note) {
        return service.addNote(note);
    }

    @GetMapping("/notes")
    public List<Note> findAll() {
        return service.getAllNotes();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Note> findById(@PathVariable Long id) {
        Optional<Note> note = service.getNoteById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @PutMapping("/note/{id}")
    public int updateNote(@PathVariable Long id, @RequestBody Note note) {
        return service.updateNote(id, note);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNoteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
