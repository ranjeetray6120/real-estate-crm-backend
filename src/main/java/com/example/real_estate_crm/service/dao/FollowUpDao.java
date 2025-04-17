package com.example.real_estate_crm.service.dao;

import java.util.List;

import com.example.real_estate_crm.model.FollowUp;

public interface FollowUpDao {
    List<FollowUp> getAllFollowUps();

    FollowUp findById(Long id);

    FollowUp addFollowUp(FollowUp followUp);

    FollowUp updateFollowUp(FollowUp followUp); // ✅ Newly added method

    void deleteById(Long id);
}
