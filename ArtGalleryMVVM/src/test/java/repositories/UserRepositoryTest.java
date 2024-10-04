package repositories;

import models.model.Users;
import models.model.enums.UserType;
import models.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class UserRepositoryTest {

    @Test
    void testAddUser(){
        UserRepository userRepository = new UserRepository();
        Users user = new Users("admin@email.com",  "password",  "0777777777", "Str. Mihai Viteazul nr.7", UserType.ADMINISTRATOR , true);
        userRepository.addUser(user);
        Optional<Users> foundUser =  userRepository.getUserByEmail("admin@email.com");
        Assertions.assertTrue(foundUser.isPresent());
    }

    @Test
    void testUpdateUser(){
        UserRepository userRepository = new UserRepository();
        Users user = new Users("employee@email.com", "password",  "0788888888", "Str. Unirii nr.12", UserType.EMPLOYEE , false);
        userRepository.addUser(user);
        Users updatedUser = new Users("employee@email.com", "password",  "0788888888", "newAddress", UserType.EMPLOYEE , false);
        Optional<Users> foundUser =  userRepository.getUserByEmail("employee@email.com");
        userRepository.updateUser(foundUser.get().getId(), updatedUser);
        Optional<Users> foundUpdatedUser =  userRepository.getUserByEmail("employee@email.com");
        Users querried = foundUpdatedUser.get();
        Assertions.assertTrue(querried.getAddress().equals("newAddress"));
        userRepository.deleteUser(querried.getId());
    }

    @Test
    void testGetUserByEmail(){
        UserRepository userRepository = new UserRepository();
        Optional<Users> foundUser =  userRepository.getUserByEmail("admin@email.com");
        Assertions.assertTrue(foundUser.isPresent());
    }

    @Test
    void testGetAllUsers(){
        UserRepository userRepository = new UserRepository();
        Users user1 = new Users("1", "1",  "1", "1", UserType.EMPLOYEE , false);
        Users user3 = new Users("2", "2",  "2", "2", UserType.EMPLOYEE , false);
        Users user2 = new Users("3", "3",  "3", "3", UserType.EMPLOYEE , false);
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);
        List<Users> users = userRepository.getAllUsers();
        Assertions.assertEquals(users.size(), 4);
        userRepository.deleteUser("1");
        userRepository.deleteUser("2");
        userRepository.deleteUser("3");
    }

    @Test
    void testDeleteUser(){
        UserRepository userRepository = new UserRepository();
        Users user1 = new Users("1", "1",  "1", "1", UserType.EMPLOYEE , false);
        userRepository.addUser(user1);
        userRepository.deleteUser("1");
        Optional<Users> foundUser = userRepository.getUserByEmail("1");
        Assertions.assertFalse(foundUser.isPresent());
    }

}