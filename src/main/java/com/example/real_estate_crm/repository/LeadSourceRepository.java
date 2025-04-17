package com.example.real_estate_crm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate_crm.model.LeadSource;

public interface LeadSourceRepository extends JpaRepository<LeadSource, Long> {
}
