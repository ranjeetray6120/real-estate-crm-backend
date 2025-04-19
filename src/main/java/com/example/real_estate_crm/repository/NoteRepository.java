package com.example.real_estate_crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate_crm.model.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByLeadLeadId(Long leadId);
}
