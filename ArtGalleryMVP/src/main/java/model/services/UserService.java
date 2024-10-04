package model.services;

import model.models.Users;

import java.util.List;
import java.util.Optional;

public class UserService {
    private model.repositories.UserRepository userRepository;

    public UserService(){
        this.userRepository = new model.repositories.UserRepository();
    }

    public List<Users> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public void addUser(Users newUser) {
        userRepository.addUser(newUser);
    }
    public void updateUser(int id, Users updatedUser) {
        userRepository.updateUser(id, updatedUser);
    }
    public Optional<Users> getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }
}
