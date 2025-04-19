package com.example.real_estate_crm.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String password;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean status;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
    @JsonManagedReference  // This ensures the User entity is serialized
    private List<Lead> leads;

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
    private List<Property> properties;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FollowUp> followUps;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Note> notes;
    
 // ✅ OTP for password reset
    @Column(name = "otp_code")
    private String otpCode;

    // ✅ OTP expiration time
    @Column(name = "otp_expiry")
    private LocalDateTime otpExpiry;

    public enum Role {
        ADMIN,
        EMPLOYEE
    }
}
