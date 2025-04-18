package com.example.real_estate_crm.repository;


import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    // Custom queries can be added here if needed
    
    // Example: Find leads by status
     List<Lead> findByStatus(String status);

    // Example: Find leads by assigned user
     List<Lead> findByAssignedTo(User assignedTo);
}
