package com.example.real_estate_crm.service.dao;

import java.util.List;

import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.model.LeadStatus;


public interface LeadDao {
    List<Lead> getAllLeads();

    Lead getById(Long id);

    Lead addLead(Lead lead);

    Lead updateLead(Lead lead);

    void deleteById(Long id);

    
    List<Lead> findByStatus(LeadStatus status);
}
