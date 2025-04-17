package com.example.real_estate_crm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate_crm.model.Lead;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    List<Lead> findByAssignedToUserId(Long userId);
}
