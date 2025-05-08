package com.example.library.librarysystem.controller;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.library.librarysystem.entity.Transaction;
import com.example.library.librarysystem.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    @GetMapping("/search/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/add/{sid}/{bid}")
    public Transaction createTransaction( Transaction t,@PathVariable("sid") Long sid,@PathVariable("bid") Long bid)
    {
       return transactionService.createTransaction(t,sid,bid);
    }
	@PutMapping("/update")
	public Transaction updateTransaction(@RequestBody Transaction transaction) {
		return transactionService.updateTransaction(transaction);
	}
	
	
	
    @DeleteMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "delete success!!";
    }
}
