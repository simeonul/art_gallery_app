package com.example.server.services;

import com.example.server.models.Users;
import com.example.server.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public List<Users> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void addUser(Users newUser) {
        userRepository.addUser(newUser);
    }

    public void updateUser(int id, Users updatedUser) {
        userRepository.updateUser(id, updatedUser);
    }

    public Optional<Users> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public Optional<Users> getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }
}
