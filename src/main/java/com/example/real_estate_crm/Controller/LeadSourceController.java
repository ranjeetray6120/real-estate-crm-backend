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

import com.example.real_estate_crm.model.LeadSource;
import com.example.real_estate_crm.service.dao.LeadSourceDao;

@RestController
@RequestMapping("/api/lead-sources")
public class LeadSourceController {

    @Autowired
    private LeadSourceDao leadSourceService;

    @GetMapping
    public List<LeadSource> getAllLeadSources() {
        return leadSourceService.getAllLeadSources();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadSource> getLeadSource(@PathVariable Long id) {
        return leadSourceService.getAllLeadSources().stream()
                .filter(l -> l.getSourceId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LeadSource> createLeadSource(@RequestBody LeadSource leadSource) {
        return ResponseEntity.ok(leadSourceService.addLeadSource(leadSource));
    }

    @PutMapping
    public ResponseEntity<LeadSource> updateLeadSource(@RequestBody LeadSource leadSource) {
        return ResponseEntity.ok(leadSourceService.updateLeadSource(leadSource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeadSource(@PathVariable Long id) {
        leadSourceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
