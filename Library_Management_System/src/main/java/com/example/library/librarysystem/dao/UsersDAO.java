package com.example.library.librarysystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.librarysystem.entity.Users;



public interface UsersDAO extends JpaRepository<Users, String>{
	
	    Optional<Users> findByUsername(String username);
	

}