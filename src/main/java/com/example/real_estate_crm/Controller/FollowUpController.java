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

import com.example.real_estate_crm.model.FollowUp;
import com.example.real_estate_crm.service.dao.FollowUpDao;

@RestController
@RequestMapping("/api/followups")
public class FollowUpController {

    @Autowired
    private FollowUpDao followUpService;

    @GetMapping
    public List<FollowUp> getAllFollowUps() {
        return followUpService.getAllFollowUps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FollowUp> getFollowUp(@PathVariable Long id) {
        return followUpService.getAllFollowUps().stream()
                .filter(f -> f.getFollowupId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FollowUp> createFollowUp(@RequestBody FollowUp followUp) {
        return ResponseEntity.ok(followUpService.addFollowUp(followUp));
    }

    @PutMapping
    public ResponseEntity<FollowUp> updateFollowUp(@RequestBody FollowUp followUp) {
        return ResponseEntity.ok(followUpService.updateFollowUp(followUp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollowUp(@PathVariable Long id) {
        followUpService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
