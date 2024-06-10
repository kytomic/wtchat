package com.dev.wtchat.service;

import com.dev.wtchat.entity.User;

import java.util.Optional;

public interface UserService {

    // Create Operation
    public void createUser(User user);

    // Read Operation
    public User getUserById(int userId);

    public User getUserByDetail(User user);

    // Delete Operation
    public void deleteUserById(int userId);
}
