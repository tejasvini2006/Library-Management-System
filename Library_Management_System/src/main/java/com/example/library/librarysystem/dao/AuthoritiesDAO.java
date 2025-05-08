package com.example.library.librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.librarysystem.entity.Authorities;

public interface AuthoritiesDAO extends JpaRepository<Authorities, Long> {
}