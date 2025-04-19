package com.example.real_estate_crm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "`lead`") // Escaping 'lead' as it's a reserved keyword in some DBs like MySQL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;

    private String name;
    private String email;
    private String phone;
    private String source;
    private String status;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    @JsonBackReference // Prevents infinite recursion when serializing User -> Leads -> User...
    private User assignedTo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Version
    private Long version;  // Used for optimistic locking

    // Lifecycle callback to set createdAt automatically before persisting (only once)
    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    // Lifecycle callback to set updatedAt automatically before updating
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Custom method to return only userId and name of assignedTo (User entity)
    @JsonProperty("assignedTo")
    public User getAssignedTo() {
        if (assignedTo != null) {
            User userAssignedTo = new User();
            userAssignedTo.setUserId(assignedTo.getUserId());
            userAssignedTo.setName(assignedTo.getName());
            return userAssignedTo;
        }
        return null;
    }
}
