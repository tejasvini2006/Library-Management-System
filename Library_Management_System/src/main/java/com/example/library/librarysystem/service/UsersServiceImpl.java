package com.example.library.librarysystem.service;

import org.springframework.stereotype.Service;

import com.example.library.librarysystem.dao.UsersDAO;
import com.example.library.librarysystem.entity.Users;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersDAO usersDAO;

    public UsersServiceImpl(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDAO.findAll();
    }

    @Override
    public Optional<Users> getUserByUsername(String username) {
        return usersDAO.findByUsername(username);
    }

    @Override
    public Users createUser(Users user) {
        return usersDAO.save(user);
    }

    @Override
    public Users updateUser(String username, Users user) {
        if (usersDAO.existsById(username)) {
            user.setUsername(username);
            return usersDAO.save(user);
        }
        throw new RuntimeException("User not found");
    }

    @Override
    public void deleteUser(String username) {
        usersDAO.deleteById(username);
    }
}
