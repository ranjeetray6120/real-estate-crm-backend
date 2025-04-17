package com.example.real_estate_crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate_crm.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // Already present

    User findByEmailAndPassword(String email, String password); // Add this
}
