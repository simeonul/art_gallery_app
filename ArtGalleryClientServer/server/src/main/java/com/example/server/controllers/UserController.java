package com.example.server.controllers;


import com.example.server.facades.UserFacade;
import com.example.server.models.ArtPieceArtist;
import com.example.server.models.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/artgallery/users")
@RestController
public class UserController {

    private final UserFacade userFacade;


    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUser() {
        return new ResponseEntity<>(userFacade.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody Users newUser) {
        userFacade.addUser(newUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody Users updatedUser) {
        userFacade.updateUser(id, updatedUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Users> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userFacade.getUserByEmail(email), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable int id) {
        userFacade.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
