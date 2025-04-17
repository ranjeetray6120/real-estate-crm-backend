package com.example.real_estate_crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.real_estate_crm.model.FollowUp;
import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.repository.FollowUpRepository;
import com.example.real_estate_crm.service.dao.FollowUpDao;

@Repository
public class FollowUpDaoImpl implements FollowUpDao {

    @Autowired
    private FollowUpRepository followUpRepository;

    @Override
    public List<FollowUp> getAllFollowUps() {
        return followUpRepository.findAll();
    }

    @Override
    public FollowUp findById(Long id) {
        return followUpRepository.findById(id).orElse(null);
    }

    @Override
    public FollowUp addFollowUp(FollowUp followUp) {
        return followUpRepository.save(followUp);
    }
    
    @Override
    public FollowUp updateFollowUp(FollowUp followUp) {
        // Optional: add check if lead exists first
        return followUpRepository.save(followUp); // JPA automatically updates if ID exists
    }

    @Override
    public void deleteById(Long id) {
        followUpRepository.deleteById(id);
    }
}
