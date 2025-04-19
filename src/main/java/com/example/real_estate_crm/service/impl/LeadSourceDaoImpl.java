package com.example.real_estate_crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.real_estate_crm.model.LeadSource;
import com.example.real_estate_crm.repository.LeadSourceRepository;
import com.example.real_estate_crm.service.dao.LeadSourceDao;

@Repository
public class LeadSourceDaoImpl implements LeadSourceDao {

    @Autowired
    private LeadSourceRepository leadSourceRepository;

    @Override
    public List<LeadSource> getAllLeadSources() {
        return leadSourceRepository.findAll();
    }

    @Override
    public LeadSource findById(Long id) {
        return leadSourceRepository.findById(id).orElse(null);
    }

    @Override
    public LeadSource addLeadSource(LeadSource leadSource) {
        return leadSourceRepository.save(leadSource);
    }
    
    @Override
    public LeadSource updateLeadSource(LeadSource leadSource) {
    	return leadSourceRepository.save(leadSource);
    }

    @Override
    public void deleteById(Long id) {
        leadSourceRepository.deleteById(id);
    }
}
