package com.example.real_estate_crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate_crm.model.Property;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByAssignedToUserId(Long userId);
}
