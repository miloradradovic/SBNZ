package com.example.SBNZ.service;

import com.example.SBNZ.model.User;
import com.example.SBNZ.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User registerUser(User existUser) {
        return userRepository.save(existUser);
    }
}
