package com.example.library.librarysystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.librarysystem.entity.Student;
import com.example.library.librarysystem.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/search/{id}")
    public Student searchStudent(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    	
    }
    @PostMapping("/add")
    public Student createStudent(@RequestBody Student book) {
        return studentService.createStudent(book);
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student book)
    {
    	return studentService.updateStudent(book);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
    	studentService.deleteStudent(id);
    	return "Delete success!";
    }
}