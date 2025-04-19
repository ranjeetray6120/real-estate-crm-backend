package com.example.real_estate_crm.service.dao;

import java.util.List;

import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.model.Property;

public interface PropertyDao {
    List<Property> getAllProperties();
    Property findById(Long id);
    Property addProperty(Property property);
    Property updateProperty(Property property);
    void deleteById(Long id);
}
