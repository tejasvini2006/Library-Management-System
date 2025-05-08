package com.example.library.librarysystem.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.library.librarysystem.entity.Book;
import com.example.library.librarysystem.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search/{id}")
    public Book searchBooks(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    	
    }
    @PostMapping("/add")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book)
    {
    	return bookService.updateBook(book);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
    	bookService.deleteBook(id);
    	return "Delete success!";
    }
    
    
}