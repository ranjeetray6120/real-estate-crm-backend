package com.example.real_estate_crm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.real_estate_crm.model.Lead;
import com.example.real_estate_crm.service.dao.LeadDao;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadDao leadService;

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLead(@PathVariable Long id) {
        return leadService.getAllLeads().stream()
                .filter(l -> l.getLeadId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
        return ResponseEntity.ok(leadService.addLead(lead));
    }

    @PutMapping
    public ResponseEntity<Lead> updateLead(@RequestBody Lead lead) {
        return ResponseEntity.ok(leadService.updateLead(lead));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
