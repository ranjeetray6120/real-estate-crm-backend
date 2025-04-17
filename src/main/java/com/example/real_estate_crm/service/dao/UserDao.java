package com.example.real_estate_crm.service.dao;

import java.util.List;

import com.example.real_estate_crm.model.User;

public interface UserDao {
    List<User> getAllUsers();

    User getUserId(Long id);

    User save(User user);

    User updateUser(User user);

    void deleteById(Long id);

    User login(String email, String password);

    void logout(Long userId);
}

