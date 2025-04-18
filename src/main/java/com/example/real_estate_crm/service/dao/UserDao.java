package com.example.real_estate_crm.service.dao;

import java.util.List;
import java.util.Optional;

import com.example.real_estate_crm.model.User;

public interface UserDao {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id); // Use Optional for safety

    User save(User user);

    User updateUser(User user);

    void deleteById(Long id);

    Optional<User> findByEmail(String email); // For login, password check goes in service

    // Optionally: logout-related functionality only if you're tracking sessions
    void logout(Long userId); // You can omit this if not managing sessions server-side

	Optional<User> findById(Long id);
}
