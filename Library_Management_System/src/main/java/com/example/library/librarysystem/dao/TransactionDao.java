package com.example.library.librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.librarysystem.entity.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Long> {
}