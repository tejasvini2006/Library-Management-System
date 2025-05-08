package com.example.library.librarysystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.librarysystem.dao.BookDao;
import com.example.library.librarysystem.dao.StudentDao;
import com.example.library.librarysystem.dao.TransactionDao;
import com.example.library.librarysystem.entity.Book;
import com.example.library.librarysystem.entity.Student;
import com.example.library.librarysystem.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionRepository;
    
    @Autowired
    private StudentDao studentRepository;
    
    @Autowired
    private BookDao bookRepository;


    
    

    @Transactional
    public Transaction createTransaction(Transaction transaction,Long sid,Long bid) {
    	
    	Student temp=studentRepository.findById(sid).orElse(null);
    	
    	transaction.setStudent(temp);
    	Book b=bookRepository.findById(bid).orElse(null);
    	transaction.setBook(b);
    	transaction.setIssueDate(new Date());
        Date currentDate = new Date(); // Get current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate); // Set current date
        calendar.add(Calendar.DAY_OF_MONTH, 7); // Add 7 days
        Date newDate = calendar.getTime();
    	transaction.setReturnDate(newDate);
        return transactionRepository.save(transaction);
    }

    @Transactional
    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Transactional
    @Override
    public Transaction updateTransaction(Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(transaction.getId()).orElse(null);
        if (existingTransaction != null) {
            existingTransaction.setIssueDate(transaction.getIssueDate());
            existingTransaction.setReturnDate(transaction.getReturnDate());
            existingTransaction.setStudent(transaction.getStudent());
            existingTransaction.setBook(transaction.getBook());
            return transactionRepository.save(existingTransaction);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}
