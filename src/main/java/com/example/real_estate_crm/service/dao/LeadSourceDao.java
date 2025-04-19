package com.example.real_estate_crm.service.dao;

import java.util.List;

import com.example.real_estate_crm.model.LeadSource;

public interface LeadSourceDao {
    List<LeadSource> getAllLeadSources();
    LeadSource findById(Long id);
    LeadSource addLeadSource(LeadSource leadSource);
    LeadSource updateLeadSource(LeadSource leadSource);
    void deleteById(Long id);
}
