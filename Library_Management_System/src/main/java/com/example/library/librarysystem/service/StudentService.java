package com.example.library.librarysystem.service;

import java.util.List;

import com.example.library.librarysystem.entity.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Student student);
    void deleteStudent(Long id);
}