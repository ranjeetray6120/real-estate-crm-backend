package com.example.real_estate_crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.real_estate_crm.model.Property;
import com.example.real_estate_crm.repository.PropertyRepository;
import com.example.real_estate_crm.service.dao.PropertyDao;

@Repository
public class PropertyDaoImpl implements PropertyDao {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property findById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    @Override
    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }
    
    @Override
    public Property updateProperty(Property property) {
        // Optional: add check if lead exists first
        return propertyRepository.save(property); // JPA automatically updates if ID exists
    }

    @Override
    public void deleteById(Long id) {
        propertyRepository.deleteById(id);
    }
}
