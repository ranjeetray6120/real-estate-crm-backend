package com.example.real_estate_crm.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate_crm.model.FollowUp;

import java.util.List;

public interface FollowUpRepository extends JpaRepository<FollowUp, Long> {
    List<FollowUp> findByLeadLeadId(Long leadId);
}
