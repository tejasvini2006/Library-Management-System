package com.example.library.librarysystem.service;

import java.util.List;

import com.example.library.librarysystem.entity.Transaction;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction,Long sid,Long bid);
    Transaction getTransactionById(Long id);
    List<Transaction> getAllTransactions();
    Transaction updateTransaction(Transaction transaction);
    void deleteTransaction(Long id);
}