package com.example.real_estate_crm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.service.dao.LeadDao;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadDao leadService;

    // Get all leads
    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    // Get a specific lead by ID
    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLead(@PathVariable Long id) {
        Lead lead = leadService.getById(id);
        if (lead != null) {
            return ResponseEntity.ok(lead);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new lead
    @PostMapping
    public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
        Lead createdLead = leadService.addLead(lead);
        return ResponseEntity.ok(createdLead);
    }

    // Update an existing lead
    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(@PathVariable Long id, @RequestBody Lead lead) {
        lead.setLeadId(id);
        Lead updatedLead = leadService.updateLead(lead);
        return ResponseEntity.ok(updatedLead);
    }

    // Delete a lead by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
