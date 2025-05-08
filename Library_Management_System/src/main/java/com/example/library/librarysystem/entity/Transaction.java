package com.example.library.librarysystem.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;


@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;
    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    
    
    // Constructors, Getters, and Setters
    public Transaction() {}
    
    public Transaction(Date issueDate, Date returnDate, Student student, Book book) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.student = student;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}