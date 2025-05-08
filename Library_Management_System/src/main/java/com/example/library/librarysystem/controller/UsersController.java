package com.example.library.librarysystem.controller;

import org.springframework.web.bind.annotation.*;

import com.example.library.librarysystem.entity.Users;
import com.example.library.librarysystem.service.UsersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{username}")
    public Optional<Users> getUserByUsername(@PathVariable String username) {
        return usersService.getUserByUsername(username);
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @PutMapping("/{username}")
    public Users updateUser(@PathVariable String username, @RequestBody Users user) {
        return usersService.updateUser(username, user);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        usersService.deleteUser(username);
    }
}
