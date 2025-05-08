package com.example.library.librarysystem.service;

import java.util.List;
import java.util.Optional;

import com.example.library.librarysystem.entity.Users;

public interface UsersService {
    List<Users> getAllUsers();
    Optional<Users> getUserByUsername(String username);
    Users createUser(Users user);
    Users updateUser(String username, Users user);
    void deleteUser(String username);
}
