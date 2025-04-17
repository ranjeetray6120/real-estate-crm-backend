package com.example.real_estate_crm.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "leads")
@Data
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

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "lead", cascade = CascadeType.ALL)
    private List<FollowUp> followUps;

    @OneToMany(mappedBy = "lead", cascade = CascadeType.ALL)
    private List<Note> notes;

    public enum Status {
        NEW,
        IN_PROGRESS,
        CONVERTED,
        LOST
    }
}
