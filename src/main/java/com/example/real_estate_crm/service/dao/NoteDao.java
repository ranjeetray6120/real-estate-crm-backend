package com.example.real_estate_crm.service.dao;

import java.util.List;

import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.model.Note;

public interface NoteDao {
    List<Note> getAllNotes();
    Note findById(Long id);
    Note addNote(Note note);
    Note updateNote(Note note);
    void deleteById(Long id);
}
