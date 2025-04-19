package com.example.real_estate_crm.service.dao;

import java.util.List;

import com.example.real_estate_crm.model.Lead;

public interface LeadDao {
    List<Lead> getAllLeads();

    Lead getById(Long id);

    Lead addLead(Lead lead);

    Lead updateLead(Lead lead); // ✅ Newly added method

    void deleteById(Long id);
}
