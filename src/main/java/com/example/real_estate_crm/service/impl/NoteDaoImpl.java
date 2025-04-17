package com.example.real_estate_crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.model.Note;
import com.example.real_estate_crm.repository.NoteRepository;
import com.example.real_estate_crm.service.dao.NoteDao;

@Repository
public class NoteDaoImpl implements NoteDao {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        // Optional: add check if lead exists first
        return noteRepository.save(note); // JPA automatically updates if ID exists
    }
    
    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
