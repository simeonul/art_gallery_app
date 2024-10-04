package com.example.server.facades;


import com.example.server.models.Users;
import com.example.server.services.NotifierService;
import com.example.server.services.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFacade {

    private final UserService userService;
    private final NotifierService notifierService;

    public UserFacade(UserService userService, NotifierService notifierService) {
        this.userService = userService;
        this.notifierService = notifierService;
    }

    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    public void addUser(Users newUser) {
        userService.addUser(newUser);
    }

    public void updateUser(int id, Users updatedUser) {
        Users beforeUpdate = getUserById(id);
        userService.updateUser(id, updatedUser);
        if (getUserByEmail(updatedUser.getEmail()) != null) {
            if (!beforeUpdate.getEmail().equals(updatedUser.getEmail()) || !beforeUpdate.getPassword().equals(updatedUser.getPassword())) {
                String notification = "Your credentials for the ArtGallery App have changed! ";
                notification += "New email: ";
                notification += updatedUser.getEmail();
                notification += ", new password: ";
                notification += updatedUser.getPassword();
                notifierService.sendSMS(notification);
                notifierService.sendEmail(notification, updatedUser.getEmail());
            }
        }
    }

    public Users getUserByEmail(String email) {
        return userService.getUserByEmail(email).orElseThrow(() -> new RuntimeException("No user could be found with the email: " + email));
    }

    public Users getUserById(int id) {
        return userService.getUserById(id).orElseThrow(() -> new RuntimeException("No user could be found with the id: " + id));
    }

    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
}
