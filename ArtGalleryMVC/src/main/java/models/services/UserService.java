package models.services;


import models.model.Users;
import models.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

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

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }
}
