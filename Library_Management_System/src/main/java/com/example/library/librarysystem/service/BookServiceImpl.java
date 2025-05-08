package com.example.library.librarysystem.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.librarysystem.dao.BookDao;
import com.example.library.librarysystem.entity.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book createBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookDao.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        Book existingBook = bookDao.findById(book.getId()).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setAvailable(book.isAvailable());
            return bookDao.save(existingBook);
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        bookDao.deleteById(id);
    }
}