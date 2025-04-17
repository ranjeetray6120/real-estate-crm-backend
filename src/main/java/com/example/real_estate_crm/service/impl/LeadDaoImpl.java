package com.example.real_estate_crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.repository.LeadRepository;
import com.example.real_estate_crm.service.dao.LeadDao;


@Repository
public class LeadDaoImpl implements LeadDao {

    @Autowired
    private LeadRepository leadRepository;

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
        return leadRepository.save(lead);
    }

    @Override
    public Lead updateLead(Lead lead) {
        // Optional: add check if lead exists first
        return leadRepository.save(lead); // JPA automatically updates if ID exists
    }

    @Override
    public void deleteById(Long id) {
        leadRepository.deleteById(id);
    }
}
