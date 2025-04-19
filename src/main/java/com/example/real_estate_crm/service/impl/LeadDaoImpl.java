package com.example.real_estate_crm.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.model.User;
import com.example.real_estate_crm.repository.LeadRepository;
import com.example.real_estate_crm.repository.UserRepository;
import com.example.real_estate_crm.service.dao.LeadDao;

@Service
public class LeadDaoImpl implements LeadDao {

    @Autowired
    private LeadRepository leadRepository;
    
    @Autowired
    private UserRepository userRepository;  // Autowired to handle the user lookup

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public Lead getById(Long id) {
        return leadRepository.findById(id).orElse(null);
    }

    @Override
    public Lead addLead(Lead lead) {
        // createdAt and updatedAt are set in the entity automatically (via @PrePersist)
        return leadRepository.save(lead);
    }

    @Override
    public Lead updateLead(Lead lead) {
        // Fetch the existing lead from the database to check if it exists
        Lead existingLead = leadRepository.findById(lead.getLeadId())
                .orElseThrow(() -> new RuntimeException("Lead not found"));

        // Fetch the assigned user based on the passed userId
        User assignedUser = userRepository.findById(lead.getAssignedTo().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Set the updated fields
        existingLead.setName(lead.getName());
        existingLead.setEmail(lead.getEmail());
        existingLead.setPhone(lead.getPhone());
        existingLead.setSource(lead.getSource());
        existingLead.setStatus(lead.getStatus());
        existingLead.setAssignedTo(assignedUser);
        existingLead.setUpdatedAt(LocalDateTime.now());

        // Ensure the version is not null; it should be automatically managed by Hibernate
        // Make sure no manual manipulation of version is done
        
        try {
            // Save the updated lead back to the repository
            return leadRepository.save(existingLead);
        } catch (OptimisticLockingFailureException ex) {
            throw new RuntimeException("Lead was updated by another transaction, please try again.");
        }
    }

    @Override
    public void deleteById(Long id) {
        leadRepository.deleteById(id);
    }
}
