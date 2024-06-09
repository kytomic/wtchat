package com.dev.wtchat.service;

import com.dev.wtchat.repository.UserRepository;
import com.dev.wtchat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> retrievedUser = userRepository.findById(userId);
        return retrievedUser.orElse(null);
    }

    @Override
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }
}
