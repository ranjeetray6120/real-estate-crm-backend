package com.example.real_estate_crm.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lead_sources")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sourceId;

    private String sourceName;
}
